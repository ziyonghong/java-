package com.zyh.applet0603;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.sound.midi.*;
import javax.swing.*;

import com.zyh.applet0603.Keyboard.Key;

/*
   This class creates a keyboard component that knows how to play a specific 
   instrument.
   //这个类创建了一个知道如何执行特定操作的键盘组件乐器。
*/

public class Keyboard extends JPanel {
	public final static Color KEY_BLUE = new Color(204, 204, 255);

	public final static int KEY_HEIGHT = 80, KEY_WIDTH = 16;

	private Key theKey;

	private MidiChannel channel;

	private Synthesizer synthesizer;

	private Vector<Key> blackKeys = new Vector<Key>();
	private Vector<Key> keys = new Vector<Key>();
	private Vector<Key> whiteKeys = new Vector<Key>();

	public Keyboard() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(42 * KEY_WIDTH + 1, KEY_HEIGHT + 1));

		int transpose = 24;
		int[] whiteIDs = { 0, 2, 4, 5, 7, 9, 11 };

		for (int i = 0, x = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++, x += KEY_WIDTH) {
				int keyNum = i * 12 + whiteIDs[j] + transpose;
				whiteKeys.add(new Key(x, 0, KEY_WIDTH, KEY_HEIGHT, keyNum));
			}
		}

		for (int i = 0, x = 0; i < 6; i++, x += KEY_WIDTH) {
			int keyNum = i * 12 + transpose;

			blackKeys.add(new Key((x += KEY_WIDTH) - 4, 0, KEY_WIDTH / 2, KEY_HEIGHT / 2, keyNum + 1));
			blackKeys.add(new Key((x += KEY_WIDTH) - 4, 0, KEY_WIDTH / 2, KEY_HEIGHT / 2, keyNum + 3));
			x += KEY_WIDTH;

			blackKeys.add(new Key((x += KEY_WIDTH) - 4, 0, KEY_WIDTH / 2, KEY_HEIGHT / 2, keyNum + 6));
			blackKeys.add(new Key((x += KEY_WIDTH) - 4, 0, KEY_WIDTH / 2, KEY_HEIGHT / 2, keyNum + 8));
			blackKeys.add(new Key((x += KEY_WIDTH) - 4, 0, KEY_WIDTH / 2, KEY_HEIGHT / 2, keyNum + 10));
		}

		keys.addAll(blackKeys);
		keys.addAll(whiteKeys);

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// Identify the key that was pressed. A null
				// value indicates something other than a key
				// was pressed.

				theKey = getKey(e.getPoint());

				// If a key was pressed ...

				if (theKey != null) {
					// Tell key to start playing note.

					theKey.on();

					// Update key's visual appearance.

					repaint();
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (theKey != null) {
					// Tell key to stop playing note.

					theKey.off();

					// Update key's visual appearance.

					repaint();
				}
			}

			public void mouseExited(MouseEvent e) {
				// This method is called if the mouse is moved
				// off the keyboard component. If a key was
				// pressed, we release that key.

				if (theKey != null) {
					// Tell key to stop playing note.

					theKey.off();

					// Update key's visual appearance.

					repaint();

					// The following assignment is needed so
					// that we don't execute the code within
					// mouseReleased()'s if statement should we
					// release a key after exiting the keyboard
					// component. There is no need to tell the
					// key to stop playing a note after we have
					// already told it to do so. Furthermore,
					// we prevent an unnecessary repaint.

					theKey = null;
				}
			}

			public Key getKey(Point point) {
				// Identify the key that was clicked.

				for (int i = 0; i < keys.size(); i++) {
					if (((Key) keys.get(i)).contains(point))
						return (Key) keys.get(i);
				}

				return null;
			}
		});
	}

	public boolean chooseInstrument(int instrumentID) {
		if (channel == null)
			return false;

		// 根据ID选择新的仪器

		channel.programChange(instrumentID);

		return true;
	}

	public String[] getInstruments() {
		if (synthesizer == null)
			return null;

		Instrument[] instruments = synthesizer.getLoadedInstruments();

		String[] ins = new String[instruments.length];

		for (int i = 0; i < instruments.length; i++)
			ins[i] = instruments[i].toString();

		return ins;
	}
   //画钢琴黑白键
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Dimension d = getSize();

		g2.setBackground(getBackground());
		g2.clearRect(0, 0, d.width, d.height);

		g2.setColor(Color.white);
		g2.fillRect(0, 0, 42 * KEY_WIDTH, KEY_HEIGHT);

		for (int i = 0; i < whiteKeys.size(); i++) {
			Key key = (Key) whiteKeys.get(i);
			if (key.isNoteOn()) {
				g2.setColor(KEY_BLUE);
				g2.fill(key);
			}

			g2.setColor(Color.black);
			g2.draw(key);
		}

		for (int i = 0; i < blackKeys.size(); i++) {
			Key key = (Key) blackKeys.get(i);
			if (key.isNoteOn()) {
				g2.setColor(KEY_BLUE);
				g2.fill(key);

				g2.setColor(Color.black);
				g2.draw(key);
			} else {
				g2.setColor(Color.black);
				g2.fill(key);
			}
		}
	}

	public void turnOff() {
		if (synthesizer == null)
			return;

		// Attempt to unload all instruments.

		synthesizer.unloadAllInstruments(synthesizer.getDefaultSoundbank());

		// Close the synthesizer, so that it can release any system resources
		// previously acquired during the open() call.

		synthesizer.close();
		synthesizer = null;
	}

	public boolean turnOn() {
		try {
			if (synthesizer == null) {
				// Obtain the default synthesizer.

				if ((synthesizer = MidiSystem.getSynthesizer()) == null)
				
					return false;

				// Open the synthesizer, so that it can acquire any system
				// resources and become operational.

				synthesizer.open();
				//System.out.println(synthesizer);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		// Attempt load all instruments.

		synthesizer.loadAllInstruments(synthesizer.getDefaultSoundbank());

		// Obtain the set of MIDI channels controlled by the synthesizer.

		MidiChannel[] midiChannels = synthesizer.getChannels();

		// There must be at least one channel. Furthermore, we assume that the
		// first channel is used by the synthesizer. If you run into a problem,
		// use the index (other than 0) of the first non-null midiChannels
		// entry.

		if (midiChannels.length == 0 || midiChannels[0] == null) {
			synthesizer.close();
			synthesizer = null;
			return false;
		}

		// Identify the channel to which note messages are sent.

		channel = midiChannels[0];

		return true;
	}

	/*
	 * This inner class describes an instrument key that knows how to start
	 * sounding and stop sounding its note. Furthermore, each key knows its size
	 * and location.
	 */

	class Key extends Rectangle {
		final static int ON = 0, OFF = 1, VELOCITY = 64;

		int kNum, noteState = OFF;

		public Key(int x, int y, int width, int height, int num) {
			super(x, y, width, height);
			kNum = num;
		}

		public boolean isNoteOn() {
			return noteState == ON;
		}

		public void off() {
			setNoteState(OFF);
			// Keyboard.this.repaint ();

			// Send the key number to the channel so the note stops sounding.
			// Also send a keyup VELOCITY, which might affect how quickly the
			// note decays.

			if (channel != null)
				channel.noteOff(kNum, VELOCITY);
		}

		public void on() {
			setNoteState(ON);
			// Keyboard.this.repaint ();

			// Send the key number (0 - 127, where 60 indicates Middle C) to the
			// channel so the note starts to sound. Also send a keydown
			// VELOCITY,
			// which indicates the speed at which a key was pressed (the
			// loudness
			// or volume of the note).

			if (channel != null)
				channel.noteOn(kNum, VELOCITY);
		}

		public void setNoteState(int state) {
			noteState = state;
		}
	}
}

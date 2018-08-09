package com.cpo.animation;

import java.util.concurrent.ThreadLocalRandom;

import com.cpo.Driver;

public class TextAnimation {

	private static String lastLine = "";
	private static byte anim;
	private static final char cursor = 219;
	private static final int leftToRightSleep = 10;
	
	// Basic animation
	public static void animate(String line, int loops, int sleep) {
		if (!Driver.animate) {
			System.out.println(line);
			return;
		}
		for (int i = 0; i < loops; i++) {
	        animate(line);
	        try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				break;
			}
	    }
	}
	
	// Blinking Cursor Stack

	public static void blinkingCursor(String line) {
		blinkingCursor(line, 10, 100);
	}

	public static void blinkingCursor(String line, int loops, int sleep) {
		blinkingCursor(line, loops, sleep, false);
	}

	public static void blinkingCursor(String line, int loops, int sleep, boolean clear) {
		if (!Driver.animate) {
			System.out.println(line);
			return;
		}
		leftToRightTextNoNewLine(line);
		for (int i = 0; i < loops; i++) {
			print(line);
			try {
				Thread.sleep(sleep);
				char cur = blink(cursor);
				lastLine += cur;
				System.out.print(cur);
				Thread.sleep(sleep);
				lastLine += cur;
				System.out.print(cur);
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				break;
			}
	    }
		if (!clear) {
			print(line);
			System.out.print("\n");
		}
		else
			TextAnimation.clearLastLine();
	}

	// Left to right animations
	public static void leftToRightText(String line) {
		if (!Driver.animate) {
			System.out.println(line);
			return;
		}
		leftToRightTextNoNewLine(line);
		print(line + "   ");
		System.out.print("\n");
	}

	private static void leftToRightTextNoNewLine(String line) {
		if (!Driver.animate) {
			System.out.println(line);
			return;
		}
		for (int i = 0; i < line.length(); i++) {
			print(line.substring(0,i));
			lastLine += " ";
			try {
				Thread.sleep(leftToRightSleep);
				System.out.print(cursor);
				Thread.sleep(leftToRightSleep);
				System.out.print(cursor);
			} catch (InterruptedException e) {
				print(line);
				break;
			}
		}
	}

	// Top to Bottom Animation Stack
	public static void topToBottomText(String lines) {
		if (!Driver.animate) {
			System.out.println(lines);
			return;
		}
		topToBottomText(lines.split("\r\n"));
	}

	public static void topToBottomText(String[] lines) {
		int loops = 10;
		int sleep = 50;
		
		for (int i = 0; i < lines.length; i++) {
			
			
			for (int z = 0; z < loops; z++) {
				if (!Driver.animate) {
					break;
				}
				print(randomLetters(lines[i]));
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					break;
				}
			}		
			print(lines[i]);
			System.out.print("\n");
		}
	}

	public static void clearLastLine() {
		if (!Driver.animate)
			return;
		print("");
	}

	private static void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (int i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1)
                System.out.print("\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }
	
	private static void animate(String line) {
        switch (anim) {
            case 1:
                print("[ \\ ] " + line);
                break;
            case 2:
                print("[ | ] " + line);
                break;
            case 3:
                print("[ / ] " + line);
                break;
            default:
                anim = 0;
                print("[ - ] " + line);
        }
        anim++;

	}
	
	private static char blink(char line) {
		anim++;
		switch (anim) {
        case 1:
            return line;
        default:
            anim = 0;
            return ' ';
		}
    
	}
	
	private static String randomLetters(String line) {
		String randomString = "";
		for (int i = 0; i < line.length(); i++) {
			String subString = line.substring(i, i + 1);
			if (!subString.equals(" ")) {
				char randomChar = (char) ThreadLocalRandom.current().nextInt(65, 123);
				randomString += randomChar;
			}
			else {
				randomString += " ";
			}
		}
		return randomString;
	}
}

package com.revature.displays;

import com.revature.interfaces.Screen;
import com.revature.sing.User;
import com.revature.textfields.Textfields;

public class LoginDisplay implements Screen {

	public LoginDisplay() {}
	
	@Override
	public Screen start() {
		Textfields.Start();
		if(User.getUsername().equals("")) {
			return new MainMenuScreen();
		}
		return null;
	}

}

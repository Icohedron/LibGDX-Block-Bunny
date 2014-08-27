package com.googlecode.icohedron.blockbunny.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.googlecode.icohedron.blockbunny.Game;
import com.googlecode.icohedron.blockbunny.handlers.GameStateManager;

public abstract class GameState {

	protected Game game;
	protected GameStateManager gsm;
	protected SpriteBatch sb;
	protected OrthographicCamera camera;
	protected OrthographicCamera hudCamera;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
		game = gsm.game();
		sb = game.getSpriteBatch();
		camera = game.getCamera();
		hudCamera = game.getHudCamera();
	}
	
	public abstract void handleInput();
	public abstract void update(float ts);
	public abstract void render();
	public abstract void dispose();
}

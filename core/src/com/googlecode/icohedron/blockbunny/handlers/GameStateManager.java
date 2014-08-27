package com.googlecode.icohedron.blockbunny.handlers;

import java.util.Stack;

import com.googlecode.icohedron.blockbunny.Game;
import com.googlecode.icohedron.blockbunny.states.GameState;
import com.googlecode.icohedron.blockbunny.states.Play;

public class GameStateManager {

	private Game game;
	private Stack<GameState> gameStates;
	
	public static final int PLAY = 3245;
	
	public GameStateManager(Game game) {
		this.game = game;
		gameStates = new Stack<GameState>();
		
		pushState(PLAY);
	}
	
	public Game game() { return game; }
	
	public void update(float ts) {
		gameStates.peek().update(ts);
	}
	
	public void render() {
		gameStates.peek().render();
	}
	
	public void setState(int state) {
		popState();
		pushState(state);
	}
	
	public void popState() {
		GameState gs = gameStates.pop();
		gs.dispose();
	}
	
	public void pushState(int state) {
		gameStates.push(getState(state));
	}
	
	private GameState getState(int state) {
		if (state == PLAY) return new Play(this);
		return null;
	}
}





















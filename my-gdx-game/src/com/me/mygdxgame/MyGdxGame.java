
package com.me.mygdxgame; 

import com.badlogic.gdx.ApplicationListener; 
import com.badlogic.gdx.Gdx; 
import com.badlogic.gdx.graphics.GL10; 
import com.badlogic.gdx.graphics.OrthographicCamera; 
import com.badlogic.gdx.graphics.Texture; 
import com.badlogic.gdx.graphics.Texture.TextureFilter; 
import com.badlogic.gdx.graphics.g2d.Sprite; 
import com.badlogic.gdx.graphics.g2d.SpriteBatch; 
import com.badlogic.gdx.graphics.g2d.TextureRegion; 

public class MyGdxGame implements ApplicationListener { 
	private OrthographicCamera camera; 
	private SpriteBatch batch; 
	private Texture texture; 
	private Texture villano; 
	private Sprite sprite; 
	private Texture texture_nave; 
	private Sprite sprite_nave; 
	private Texture texture_villano; 
	private Sprite sprite_villano; 
	 
	 
	int Rotacion=0; 
	
	int rotanave=0;
	 
	@Override 
	public void create() {		 
		float w = Gdx.graphics.getWidth(); 
		float h = Gdx.graphics.getHeight(); 
		 
		camera = new OrthographicCamera(1, h/w); 
		batch = new SpriteBatch(); 
		 
		texture = new Texture(Gdx.files.internal("data/libgdx.png")); 
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear); 
		texture_nave = new Texture(Gdx.files.internal("data/nave.png")); 


		texture = new Texture(Gdx.files.internal("data/libgdx.png")); 
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear); 
		texture_villano = new Texture(Gdx.files.internal("data/villano.png")); 
		 
		TextureRegion region1 = new TextureRegion(texture, 0, 0, 512, 275); 
		 
		sprite = new Sprite(region1); 
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth()); 
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2); 
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2); 
		sprite.setPosition(0,0); 
		 
		sprite_nave = new Sprite(texture_nave,128,64); 
		sprite_nave.setPosition(-0.2f,-0.2f); 
		sprite_nave.setSize(0.2f,0.2f); 
		
		sprite_villano = new Sprite(texture_villano,64,64); 
		sprite_villano.setPosition(-0.4f,-0.4f); 
		sprite_villano.setSize(0.2f,0.2f); 
		
		
		 
	} 
	 
	@Override 
	public void dispose() { 
		batch.dispose(); 
		texture.dispose(); 
	} 

	@Override 
	public void render() {		 
		Gdx.gl.glClearColor(0.4f, 0.5f,1 ,1 ); 
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); 
		sprite.setRotation(Rotacion); 
		Rotacion++; 
		
		sprite_nave.rotate((float) (+10));
		sprite.setRotation(rotanave); 
		rotanave++; 
		 
		 
		 
		batch.setProjectionMatrix(camera.combined); 
		batch.begin(); 
		sprite_nave.draw(batch); 
		sprite.draw(batch); 
		batch.end(); 
		 
		 
	} 

	@Override 
	public void resize(int width, int height) { 
	} 

	@Override 
	public void pause() { 
	} 

	@Override 
	public void resume() { 
	} 
}
		
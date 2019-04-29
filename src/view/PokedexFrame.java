package view;

import javax.swing.JFrame;
import controller.PokedexController;

public class PokedexFrame extends JFrame
{
	private PokedexController pokeController;
	private PokedexPanel pokePanel;
	
	public PokedexFrame(PokedexController pokeController)
	{
		super();
		this.pokeController = pokeController;
		this.pokePanel = new PokedexPanel(pokeController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(pokePanel);;
		this.setSize(800, 600);
		this.setTitle("Pokedex");
		this.setResizable(false);
		this.setVisible(true);
	}
}

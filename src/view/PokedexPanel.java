package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.PokedexController;
import controller.Controller;
	
public class PokedexPanel extends JPanel
{
	private PokedexController app;
	private SpringLayout appLayout;
	
	private JButton changeButton;
	private  JComboBox pokedexDropdown;
	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField;
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
	private ImageIcon pokemonIcon;
	
	public PokedexPanel(PokedexController app)
	{
		super();
		this.app = app;
		
		this.appLayout = new SpringLayout();
		
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/pokeball.png"));
		
		numberField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.EAST, numberField, -32, SpringLayout.EAST, this);
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -32, SpringLayout.EAST, this);
		attackField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.EAST, attackField, -32, SpringLayout.EAST, this);
		enhancementField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.EAST, enhancementField, -32, SpringLayout.EAST, this);
		healthField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.EAST, nameField, 0, SpringLayout.EAST, healthField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, -32, SpringLayout.EAST, this);
		
		
		healthLabel = new JLabel("This pokemon health is");
		appLayout.putConstraint(SpringLayout.NORTH, attackField, 0, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -269, SpringLayout.EAST, this);
		numberLabel = new JLabel("This pokemon number is");
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 31, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, 0, SpringLayout.EAST, healthLabel);
		
		evolveLabel = new JLabel("This pokemon can evolve");
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, -5, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 35, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.EAST, evolveLabel, 0, SpringLayout.EAST, healthLabel);
		attackLabel = new JLabel("This pokemon attack level is ");
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 0, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, 0, SpringLayout.EAST, healthLabel);
		enhanceLabel = new JLabel("This pokemon enhancement level is");
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 43, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.EAST, enhanceLabel, 0, SpringLayout.EAST, healthLabel);
		nameLabel = new JLabel("My name is");
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 0, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 290, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -325, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, attackLabel, -57, SpringLayout.NORTH, nameLabel);
		
		imageLabel = new JLabel("pokemon goes here", pokemonIcon, JLabel.CENTER);
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 196, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 42, SpringLayout.WEST, this);
		changeButton = new JButton("Click here to change the pokevalues");
		appLayout.putConstraint(SpringLayout.WEST, changeButton, 39, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, changeButton, -132, SpringLayout.SOUTH, this);
		pokedexDropdown = new JComboBox();
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 42, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 127, SpringLayout.EAST, changeButton);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexDropdown, -92, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -235, SpringLayout.EAST, this);
		
		setupDropdown();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(pokedexDropdown);
		this.add(healthField);
		this.add(numberField);
		this.add(evolveField);
		this.add(enhancementField);
		this.add(attackField);
		this.add(nameField);
		this.add(healthLabel);
		this.add(numberLabel);
		this.add(evolveLabel);
		this.add(attackLabel);
		this.add(enhanceLabel);
		this.add(nameLabel);
		this.add(imageLabel);
		this.add(changeButton);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
	}
	
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		
		if(app.isInt(attackField.getText()) && app.isDouble(enhancementField.getText()) && app.isInt(healthField.getText()))
		{
			String [] data = new String [5];
			
			//insert code here
			app.updatePokemon(index, data);
		}
	}
	
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "ultraball";
		String extension = ".png";
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
		}
		catch (NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
	}
	
	private void setupDropdown()
	{
		DefaultComboBoxModel temp = new DefaultComboBoxModel(app.buildPokedexTest());
		pokedexDropdown.setModel(temp);
	}
	
	
	private void setupLayout()
	{
		
	}
	
	
	private void updateFields(int index)
	{
		String [] data = app.getPokeData(index);
		
		attackField.setText(data[0]);
		enhancementField.setText(data[1]);
		healthField.setText(data[2]);
		nameField.setText(data[3]);
		evolveField.setText(data[4]);
		numberField.setText(data[5]);
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sendDataToController();
			}
		});
		
		pokedexDropdown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
			String name = pokedexDropdown.getSelectedItem().toString();
			changeImageDisplay(name);
			}
		});
		pokedexDropdown.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent selection)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				updateFields(pokedexDropdown.getSelectedIndex());
				changeImageDisplay(name);
			}
		});
	}
}



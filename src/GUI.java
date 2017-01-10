import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;


@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	private Container contentPane;
	private JPanel menu, mainPage;
	private JButton ammo, weapons, apparel, aid, misc, junk, locations, character,
		vaults, housing, wrecks, farms, junkyards, truckStops, quarries, militaryBases, cities, metro, 
			POI, radioTower, factories, buildingsAndRuins, churchesAndSchools, hospitals, lakesCabinsParks, 
			nuclearSites, marinas, poiceDepartments, settlements, trade;
	
	public GUI(){
		super("Fallout 4");
		
//--------------------------------------------------
// Set up window
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());

		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(0, 0));
	
//-----------------------------------------------------------------------
// Set up content
		
		mainPage = new JPanel();
		SpringLayout springlayout = new SpringLayout();
		mainPage.setLayout(springlayout);
		mainPage.setLayout(new SpringLayout());
		contentPane.add(mainPage, BorderLayout.CENTER);
		
		menu = new JPanel();
		menu.setLayout(new GridLayout(0, 1, 0, 0));
		menu.setBackground(Color.BLACK);
		contentPane.add(menu, BorderLayout.WEST);

		character = new JButton("Character");
		ammo = new JButton("Ammo");
		weapons = new JButton("Weapons");
		apparel = new JButton("Apparel");
		aid = new JButton("Aid");
		misc = new JButton("Misc");
		junk = new JButton("Junk");
		locations = new JButton("Locations");
		
		menu.add(character);
		menu.add(ammo);
		menu.add(weapons);
		menu.add(apparel);
		menu.add(aid);
		menu.add(misc);
		menu.add(junk);
		menu.add(locations);
		
		character.addActionListener(new characterClick());
		ammo.addActionListener(new ammoClick());
		weapons.addActionListener(new weaponsClick());
		apparel.addActionListener(new apparelClick());
		aid.addActionListener(new aidClick());
		misc.addActionListener(new miscClick());
		junk.addActionListener(new junkClick());
		locations.addActionListener(new locationsClick());

//-----------------------------------------------------------------------
// Color Buttons
		
		ammo.setBackground(Color.WHITE);
		weapons.setBackground(Color.WHITE);
		apparel.setBackground(Color.WHITE);
		aid.setBackground(Color.WHITE);
		misc.setBackground(Color.WHITE);
		junk.setBackground(Color.WHITE);
		locations.setBackground(Color.WHITE);
		character.setBackground(Color.WHITE);
		
//---------------------------------------------------------------------------
// Set up main page
		
		JLabel mainPageInstructions = new JLabel("Select a category on the left to view the content.");
		contentPane.add(mainPageInstructions, BorderLayout.PAGE_START);
		
//------------------------------------------------------------------------
// Display content
		
		setBounds(0, 0, xSize, (ySize - 50));
		setVisible(true);
		repaint();
		
	}
//-------------------------------------------------------------------------
// Listeners
	
	//must clear menu JPanel in beginning of every actionListener
	//panel.removeAll(); 
	//panel.updateUI(); -- necessary?
	
	
		private class characterClick implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				clearMainPage();
				switchSelectionColor();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class ammoClick implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				clearMainPage();
				switchSelectionColor();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
				
				String data = getAmmo();
				JTextArea ammoTable = new JTextArea();
				ammoTable.setText(data);
				ammoTable.setEditable(false);
				mainPage.add(ammoTable);
			}
		}
		
		
		private class weaponsClick implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				clearMainPage();
				switchSelectionColor();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		
		private class apparelClick implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				clearMainPage();
				switchSelectionColor();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		
		private class aidClick implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				clearMainPage();
				switchSelectionColor();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
				
				String data = getAid();
				JTextArea aidTable = new JTextArea();
				aidTable.setText(data);
				aidTable.setEditable(false);
				mainPage.add(aidTable);
			}
		}
		
		
		private class miscClick implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				clearMainPage();
				switchSelectionColor();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		
		private class junkClick implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				clearMainPage();
				switchSelectionColor();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		
		private class locationsClick implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				clearMainPage();
				switchSelectionColor();
				setLocationButtonOptions();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}

//---------------------------------------------------------------------
// Location Listeners
		
		
		private class vaultsListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class housingListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}	
		
		private class wrecksListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class farmsListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class junkYardsListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class truckStopsListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class quarriesListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class militaryBasesListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class citiesListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class metroListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class POIListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class raidioTowerListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class factoriesListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class buildingsAndRuinsListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class churchesAndSchoolsListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}

		private class hospitalsListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class lakesCabinsParksListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class nuclearSitesListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class marinasListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class policeDepartmentsListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view locations
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class settlementsListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view where settlements = 'Y'
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		private class tradeListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ea) {
				//view where trade = 'Y'
				switchSelectionColorLocations();
				JButton input =  (JButton) ea.getSource();
				input.setBackground(Color.GREEN);
			}
		}
		
		
//----------------------------------------------------------------------
// Other Functions
		

		private void clearMainPage(){
			
			mainPage.removeAll(); 
			mainPage.updateUI();
		}
		
		private void switchSelectionColor(){
			if(ammo.getBackground() == Color.GREEN || weapons.getBackground() == Color.GREEN 
					|| apparel.getBackground() == Color.GREEN || aid.getBackground() == Color.GREEN
					|| misc.getBackground() == Color.GREEN || junk.getBackground() == Color.GREEN
					|| locations.getBackground() == Color.GREEN || character.getBackground() == Color.GREEN)
			{
				ammo.setBackground(Color.WHITE);
				weapons.setBackground(Color.WHITE);
				apparel.setBackground(Color.WHITE);
				aid.setBackground(Color.WHITE);
				misc.setBackground(Color.WHITE);
				junk.setBackground(Color.WHITE);
				locations.setBackground(Color.WHITE);
				character.setBackground(Color.WHITE);
				
				menu.revalidate();
				menu.repaint();
			}
		}
		
		private void switchSelectionColorLocations(){
			if(vaults.getBackground() == Color.GREEN ||
			housing.getBackground() == Color.GREEN ||
			wrecks.getBackground() == Color.GREEN ||
			farms.getBackground() == Color.GREEN ||
			junkyards.getBackground() == Color.GREEN ||
			truckStops.getBackground() == Color.GREEN ||
			quarries.getBackground() == Color.GREEN ||
			militaryBases.getBackground() == Color.GREEN ||
			cities.getBackground() == Color.GREEN ||
			metro.getBackground() == Color.GREEN ||
			POI.getBackground() == Color.GREEN ||
			radioTower.getBackground() == Color.GREEN ||
			factories.getBackground() == Color.GREEN ||
			buildingsAndRuins.getBackground() == Color.GREEN ||
			churchesAndSchools.getBackground() == Color.GREEN ||
			hospitals.getBackground() == Color.GREEN ||
			lakesCabinsParks.getBackground() == Color.GREEN ||
			nuclearSites.getBackground() == Color.GREEN ||
			marinas.getBackground() == Color.GREEN ||
			poiceDepartments.getBackground() == Color.GREEN ||
			settlements.getBackground() == Color.GREEN ||
			trade.getBackground() == Color.green)
			{
				vaults.setBackground(Color.WHITE);
				housing.setBackground(Color.WHITE);
				wrecks.setBackground(Color.WHITE);
				farms.setBackground(Color.WHITE);
				junkyards.setBackground(Color.WHITE);
				truckStops.setBackground(Color.WHITE);
				quarries.setBackground(Color.WHITE); 
				militaryBases.setBackground(Color.WHITE);
				cities.setBackground(Color.WHITE);
				metro.setBackground(Color.WHITE);
				POI.setBackground(Color.WHITE);
				radioTower.setBackground(Color.WHITE);
				factories.setBackground(Color.WHITE); 
				buildingsAndRuins.setBackground(Color.WHITE);
				churchesAndSchools.setBackground(Color.WHITE);
				hospitals.setBackground(Color.WHITE);
				lakesCabinsParks.setBackground(Color.WHITE);
				nuclearSites.setBackground(Color.WHITE);
				marinas.setBackground(Color.WHITE);
				poiceDepartments.setBackground(Color.WHITE);
				settlements.setBackground(Color.WHITE);
				trade.setBackground(Color.WHITE);
				
				menu.revalidate();
				menu.repaint();
			}
		}

		private void setLocationButtonOptions(){
			
		// Instantiate buttons
			
			settlements = new JButton("Settlements");
			trade = new JButton("Locations Where Trade is Available");
			vaults = new JButton("Vaults"); 
			housing = new JButton("Housing");
			wrecks = new JButton("Wrecks");
			farms = new JButton("Farms");
			junkyards = new JButton("Junkyards");
			truckStops = new JButton("Truck Stops");
			quarries = new JButton("Quarries"); 
			militaryBases = new JButton("Military Bases");
			cities = new JButton("Cities"); 
			metro = new JButton("Metro"); 
			POI = new JButton("Points of Interest"); 
			radioTower = new JButton("Radio Towers"); 
			factories = new JButton("Factories"); 
			buildingsAndRuins = new JButton("Buildings and Ruins");
			churchesAndSchools = new JButton("Churches and Schools");
			hospitals = new JButton("Hospitals");
			lakesCabinsParks = new JButton("Lakes, Cabins, and Parks"); 
			nuclearSites = new JButton("Nuclear Sites");
			marinas = new JButton("Marinas");
			poiceDepartments = new JButton("Police Departments");
	
			
			
		// Set buttons to white
		
			settlements.setBackground(Color.WHITE);
			trade.setBackground(Color.white);
			vaults.setBackground(Color.WHITE);
			housing.setBackground(Color.WHITE);
			wrecks.setBackground(Color.WHITE);
			farms.setBackground(Color.WHITE);
			junkyards.setBackground(Color.WHITE);
			truckStops.setBackground(Color.WHITE);
			quarries.setBackground(Color.WHITE); 
			militaryBases.setBackground(Color.WHITE);
			cities.setBackground(Color.WHITE);
			metro.setBackground(Color.WHITE);
			POI.setBackground(Color.WHITE);
			radioTower.setBackground(Color.WHITE);
			factories.setBackground(Color.WHITE); 
			buildingsAndRuins.setBackground(Color.WHITE);
			churchesAndSchools.setBackground(Color.WHITE);
			hospitals.setBackground(Color.WHITE);
			lakesCabinsParks.setBackground(Color.WHITE);
			nuclearSites.setBackground(Color.WHITE);
			marinas.setBackground(Color.WHITE);
			poiceDepartments.setBackground(Color.WHITE);
			
			
			// Add all the buttons to the mainPage JPanel		
		
			mainPage.add(settlements);
			mainPage.add(trade);
			mainPage.add(vaults); 
			mainPage.add(housing);
			mainPage.add(wrecks);
			mainPage.add(farms);
			mainPage.add(junkyards);
			mainPage.add(truckStops);
			mainPage.add(quarries); 
			mainPage.add(militaryBases);
			mainPage.add(cities); 
			mainPage.add(metro); 
			mainPage.add(POI); 
			mainPage.add(radioTower); 
			mainPage.add(factories); 
			mainPage.add(buildingsAndRuins);
			mainPage.add(churchesAndSchools);
			mainPage.add(hospitals);
			mainPage.add(lakesCabinsParks); 
			mainPage.add(nuclearSites);
			mainPage.add(marinas);
			mainPage.add(poiceDepartments);		
			
		// Add Listeners
			
			settlements.addActionListener(new settlementsListener());
			trade.addActionListener(new tradeListener());
			vaults.addActionListener(new vaultsListener()); 
			housing.addActionListener(new housingListener());
			wrecks.addActionListener(new wrecksListener());
			farms.addActionListener(new farmsListener());
			junkyards.addActionListener(new junkYardsListener());
			truckStops.addActionListener(new truckStopsListener());
			quarries.addActionListener(new quarriesListener()); 
			militaryBases.addActionListener(new militaryBasesListener());
			cities.addActionListener(new citiesListener()); 
			metro.addActionListener(new metroListener()); 
			POI.addActionListener(new POIListener()); 
			radioTower.addActionListener(new raidioTowerListener()); 
			factories.addActionListener(new factoriesListener()); 
			buildingsAndRuins.addActionListener(new buildingsAndRuinsListener());
			churchesAndSchools.addActionListener(new churchesAndSchoolsListener());
			hospitals.addActionListener(new hospitalsListener());
			lakesCabinsParks.addActionListener(new lakesCabinsParksListener()); 
			nuclearSites.addActionListener(new nuclearSitesListener());
			marinas.addActionListener(new marinasListener());
			poiceDepartments.addActionListener(new policeDepartmentsListener());
		
		}
	
//---------------------------------------------------------------------------------------------
// View Tables


		public String getAmmo(){

			String connectionUrl = "jdbc:sqlserver://acaddb.graceland.edu:1433;"
					+ "databaseName=SF_FALLOUT;user=sa;password=XXXXXXX";

			// Declare the JDBC objects.
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				// Establish the connection.
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(connectionUrl);

				// Create and execute an SQL statement that returns some data.
				String SQL = "select * from ammo";
				stmt = con.createStatement();
				rs = stmt.executeQuery(SQL);
				Thread.sleep(1);


				String xAmmo = "ID\tName\t                       Value\n";
				// Iterate through the data in the result set and display it.
				while(rs.next()){
					String id = rs.getString("ammo_id");
					String name = rs.getString("ammo_name");
					int value = rs.getInt("value");
					if (name.contains("Plasma Cartrige") || name.contains("Gamma Round") || name.contains("Syringer Ammo")){;
						xAmmo += (id + "\t" + name + "\t" + value + "\t\n");}
					else
						xAmmo += (id + "\t" + name + "\t\t" + value + "\t\n");
				}

				return xAmmo;
			}

			// Handle any errors that may have occurred.
			catch (Exception e) {
				e.printStackTrace();
			} finally {

				if (stmt != null)
					try {
						stmt.close();
					} catch (Exception e) {
					}
				if (con != null)
					try {
						con.close();
					} catch (Exception e) {
					}
			}
			String oops = "it didnt work";
			return oops;
		}
		
		public String getAid(){

			String connectionUrl = "jdbc:sqlserver://acaddb.graceland.edu:1433;"
					+ "databaseName=SF_FALLOUT;user=sa;password=XXXXXXX";

			// Declare the JDBC objects.
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				// Establish the connection.
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(connectionUrl);

				// Create and execute an SQL statement that returns some data.
				String SQL = "select * from aid";
				stmt = con.createStatement();
				rs = stmt.executeQuery(SQL);
				Thread.sleep(1);


				String sAid = "ID\tName\t\tEffect\t\t\t\tAddiction\tValue\n";
				// Iterate through the data in the result set and display it.
				while(rs.next()){
					String id = rs.getString("aid_id");
					String name = rs.getString("aid_name");
					String effect = rs.getString("effect");
					String newString = effect.trim();
					System.out.println(newString.length());
					String addiction = rs.getString("addiction");
					int value = rs.getInt("value");
					if (name.contains("Day Tripper") || name.contains("Grape Mentals") || name.contains("Mysterious Serum")
							|| name.contains("Orange Mentats") || name.contains("Psycho") || name.contains("Psycho Jet")
							|| name.contains("Psychobuff") || name.contains("Psychotats") || name.contains("RadAway")
							|| name.contains("Skeeto Spit") || name.contains("Vault 81 Cure") || name.contains("X-111 Compound")
							|| name.contains("Berry Mentals") || name.contains("Psycho")){
						if(newString.length() >=40){
							sAid += (id + "\t" + name + "\t" + effect + "\t" + addiction + "\t" + value + "\t\n");
						}
						else if(newString.length() < 25){
							sAid += (id + "\t" + name + "\t" + effect + "\t\t" + addiction + "\t" + value + "\t\n");
						}
						else
							sAid += (id + "\t" + name + "\t" + effect + "\t\t" + addiction + "\t" + value + "\t\n");
					}
					else{
						if(newString.length() >=40){
							sAid += (id + "\t" + name + "\t\t" + effect + "\t" + addiction + "\t" + value + "\t\n");}
						else if(newString.length() < 25){
							sAid += (id + "\t" + name + "\t\t" + effect + "\t\t" + addiction + "\t" + value + "\t\n");
						}
						else
							sAid += (id + "\t" + name + "\t\t" + effect + "\t" + addiction + "\t" + value + "\t\n");}}

				return sAid;
			}

			// Handle any errors that may have occurred.
			catch (Exception e) {
				e.printStackTrace();
			} finally {

				if (stmt != null)
					try {
						stmt.close();
					} catch (Exception e) {
					}
				if (con != null)
					try {
						con.close();
					} catch (Exception e) {
					}
			}
			String oops = "it didnt work";
			return oops;
		}
		
		public String getJunk(){

			String connectionUrl = "jdbc:sqlserver://acaddb.graceland.edu:1433;"
					+ "databaseName=SF_FALLOUT;user=sa;password=XXXXXXX";

			// Declare the JDBC objects.
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				// Establish the connection.
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(connectionUrl);

				// Create and execute an SQL statement that returns some data.
				String SQL = "select * from ammo";
				stmt = con.createStatement();
				rs = stmt.executeQuery(SQL);
				Thread.sleep(1);


				String xAmmo = "ID\tName\t                       Value\n";
				// Iterate through the data in the result set and display it.
				while(rs.next()){
					String id = rs.getString("ammo_id");
					String name = rs.getString("ammo_name");
					int value = rs.getInt("value");
					if (name.contains("Plasma Cartrige") || name.contains("Gamma Round") || name.contains("Syringer Ammo")){;
						xAmmo += (id + "\t" + name + "\t" + value + "\n");}
					else
						xAmmo += (id + "\t" + name + "\t\t" + value + "\n");
				}

				return xAmmo;
			}

			// Handle any errors that may have occurred.
			catch (Exception e) {
				e.printStackTrace();
			} finally {

				if (stmt != null)
					try {
						stmt.close();
					} catch (Exception e) {
					}
				if (con != null)
					try {
						con.close();
					} catch (Exception e) {
					}
			}
			String oops = "it didnt work";
			return oops;
		}  


} // last bracket

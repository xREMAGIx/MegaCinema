/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;
import MCViews.MainFrane;


import MCViews.LoginMCView;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author DELL
 */
public class MCMain {
        public static void main(String args[]) {
            //LoginMCView loginView = new LoginMCView();
            //loginView.setVisible(true);
            try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MainFrane mainf = new MainFrane();
		mainf.setVisible(true);
        }
    
}




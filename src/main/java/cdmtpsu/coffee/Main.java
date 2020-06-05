package cdmtpsu.coffee;

import cdmtpsu.coffee.data.Database;
import cdmtpsu.coffee.ui.order.SendMessageDialog;
import cdmtpsu.coffee.ui.welcome.WelcomeFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static final ArrayList<Image> ICONS;

    public static final ImageIcon INGREDIENTS_TAB_ICON;
    public static final ImageIcon MENU_ITEM_TAB_ICON;
    public static final ImageIcon ORDER_ITEM_TAB_ICON;
    public static final ImageIcon ORDER_TAB_ICON;
    public static final ImageIcon RECIPE_ITEM_TAB_ICON;
    public static final ImageIcon USER_TAB_ICON;

    static {
        ICONS = new ArrayList<>();
        try {
            ICONS.add(ImageIO.read(Main.class.getResource("/x16.png")));
            ICONS.add(ImageIO.read(Main.class.getResource("/x24.png")));
            ICONS.add(ImageIO.read(Main.class.getResource("/x32.png")));
            ICONS.add(ImageIO.read(Main.class.getResource("/x48.png")));
            ICONS.add(ImageIO.read(Main.class.getResource("/x64.png")));
            ICONS.add(ImageIO.read(Main.class.getResource("/x256.png")));

            INGREDIENTS_TAB_ICON = new ImageIcon(ImageIO.read(Main.class.getResource("/tabs/ingredients_tab.png")));
            MENU_ITEM_TAB_ICON = new ImageIcon(ImageIO.read(Main.class.getResource("/tabs/menu_item_tab.png")));
            ORDER_ITEM_TAB_ICON = new ImageIcon(ImageIO.read(Main.class.getResource("/tabs/order_item_tab.png")));
            ORDER_TAB_ICON = new ImageIcon(ImageIO.read(Main.class.getResource("/tabs/order_tab.png")));
            RECIPE_ITEM_TAB_ICON = new ImageIcon(ImageIO.read(Main.class.getResource("/tabs/recipe_item_tab.png")));
            USER_TAB_ICON = new ImageIcon(ImageIO.read(Main.class.getResource("/tabs/user_tab.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        UIManager.put("OptionPane.okButtonText", "ОК");
        UIManager.put("OptionPane.cancelButtonText", "Отмена");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        Database.getInstance(); // init
        //new StartupWindow().create();
        /*try {
            User user = Database.getInstance().getUsers().queryBuilder()
                    .where().eq(User.USERNAME_FIELD_NAME, "admin")
                    .queryForFirst();
            new MainFrame(user).setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        new WelcomeFrame().setVisible(true);
    }
}

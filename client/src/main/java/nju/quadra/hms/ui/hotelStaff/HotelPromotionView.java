package nju.quadra.hms.ui.hotelStaff;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import nju.quadra.hms.controller.HotelStaffController;
import nju.quadra.hms.net.HttpClient;
import nju.quadra.hms.vo.HotelPromotionVO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by adn55 on 2016/12/1.
 */
public class HotelPromotionView extends Parent {

    private HotelStaffController controller = new HotelStaffController(HttpClient.session.username);
    private ArrayList<HotelPromotionVO> promotions;

    public HotelPromotionView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("promotion.fxml"));
        loader.setController(this);
        this.getChildren().add(loader.load());

        loadPromotion();
    }

    @FXML
    private Pane pane;
    @FXML
    private VBox vBox;

    public void loadPromotion() throws IOException {
        promotions = controller.getHotelPromotion();
        if (promotions != null) {
            vBox.getChildren().clear();
            for (HotelPromotionVO vo : promotions) {
                vBox.getChildren().add(new HotelPromotionItem(this, vo, controller));
            }
        }
    }

    public void loadView(Node node) {
        pane.getChildren().add(node);
    }

    @FXML
    protected void onAddAction() throws IOException {
        loadView(new HotelPromotionEditView(null, controller, false, this::loadPromotion));
    }

}
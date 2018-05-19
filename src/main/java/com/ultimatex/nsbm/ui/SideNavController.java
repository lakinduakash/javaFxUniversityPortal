package com.ultimatex.nsbm.ui;

import com.ultimatex.nsbm.util.MainContainerState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class SideNavController implements Initializable {


    @FXML
    VBox sideNav;
    private OnMainItemClickListener listener;
    private MainController mainController;
    private int State = MainContainerState.PROFILE;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void loadAddMember(ActionEvent event) {
        //LibraryAssistantUtil.loadWindow(getClass().getResource("/library/assistant/ui/addmember/member_add.fxml"), "Add New Member", null);
    }

    @FXML
    private void loadAddBook(ActionEvent event) {
        //LibraryAssistantUtil.loadWindow(getClass().getResource("/library/assistant/ui/addbook/add_book.fxml"), "Add New Book", null);
        listener.onStateChanged(MainContainerState.PAYMENT);
    }

    @FXML
    private void loadMemberTable(ActionEvent event) {
        //LibraryAssistantUtil.loadWindow(getClass().getResource("/library/assistant/ui/listmember/member_list.fxml"), "Member List", null);
    }

    @FXML
    private void loadBookTable(ActionEvent event) {
        //LibraryAssistantUtil.loadWindow(getClass().getResource("/library/assistant/ui/listbook/book_list.fxml"), "Book List", null);
    }

    @FXML
    private void loadSettings(ActionEvent event) {
        //LibraryAssistantUtil.loadWindow(getClass().getResource("/library/assistant/settings/settings.fxml"), "Settings", null);
    }

    @FXML
    private void loadIssuedBookList(ActionEvent event) {

    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setListener(OnMainItemClickListener listener) {
        this.listener = listener;
    }


    public interface OnMainItemClickListener {
        void onStateChanged(int state);
    }


}


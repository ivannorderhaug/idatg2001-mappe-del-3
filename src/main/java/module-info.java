module no.ntnu.candidate.exam {
    requires javafx.controls;
    requires javafx.fxml;

    opens no.ntnu.candidate.exam to javafx.fxml;
    exports no.ntnu.candidate.exam;
}
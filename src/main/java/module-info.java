module no.ntnu.candidate.exam {
    requires javafx.controls;
    requires javafx.fxml;

    opens no.ntnu.candidate.exam;
    opens no.ntnu.candidate.exam.controller;
    opens no.ntnu.candidate.exam.model;
    exports no.ntnu.candidate.exam.controller;
    exports no.ntnu.candidate.exam.model;
    exports no.ntnu.candidate.exam;
}
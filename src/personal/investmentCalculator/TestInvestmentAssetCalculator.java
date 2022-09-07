//package personal.investmentCalculator;/*
//TODO:
//- Change xAxis tick unit to 1
//- If any fields are empty, set to 0
//- Add a yearly option too
//- Make the graph show the x and y data point if you hover over the point
//- Add a table
//- Switch to an OO design
// */
//
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
//import javafx.stage.Stage;
//
//public class TestInvestmentAssetCalculator extends Application {
//
//    private BorderPane mainLayout;
//
//    public void init() {
//        this.mainLayout = new BorderPane();
//        mainLayout.setCenter(lineChart);
//        mainLayout.setTop(personal.investmentCalculator.inputFields);
//    }
//    public static void main(String[] args) {
//        launch(InvestmentAssetCalculator.class);
//    }
//
//    @Override
//    public void start(Stage window) throws Exception {
//        Scene scene = new Scene(this.mainLayout);
//        window.setScene(scene);
//        window.show();
//    }
//    private String zeroIfEmpty(String text) {
//        if (text.length() == 0) {
//            return "0";
//        }
//        return text;
//    }
//
//}

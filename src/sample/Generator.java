package sample;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;

import java.util.LinkedList;

public class Generator {

    public LinkedList<PeriodInfo> getPeriodInfo(Settings settings) {
        LinkedList<PeriodInfo> tmp = new LinkedList<>();

        // before the game
        PeriodInfo p0 = new PeriodInfo(settings.getWaitingBeforeStart(), false, 0, "WAITING", false, false, true, false);
        tmp.add(p0);

        // main game
        int tmp_period = 1;
        for (int i = 1; i <= (settings.getNeljannesMaara() * 2); i = i + 1) {
            if(i % 2 != 0){
                PeriodInfo tmp_p = new PeriodInfo(settings.getNeljanneksenPituus(), true, i, (Integer.toString(tmp_period)+". PERIOD"), false, false, false, false);
                tmp.add(tmp_p);
                tmp_period = tmp_period + 1;
            }else {
                if(4 == i){
                    PeriodInfo tmp_p = new PeriodInfo(settings.getPitkaTauko(), true, i, "HALF TIME", true, true, true, false);
                    tmp.add(tmp_p);
                } else {
                    PeriodInfo tmp_p = new PeriodInfo(settings.getLyhytTauko(), true, i, "BREAK", true, false, true, false);
                    tmp.add(tmp_p);
                }
            }
        }

        int overtime = 1;
        boolean break_tmp = true;
        for (int i = (settings.getNeljannesMaara() * 2); i <= ((settings.getNeljannesMaara() * 2) + 20 ); i = i + 1) {
            if(break_tmp){
                PeriodInfo tmp_p = new PeriodInfo(settings.getLyhytTauko(), true, i, "BREAK", false, false, true, true);
                tmp.add(tmp_p);
            } else {
                PeriodInfo tmp_p = new PeriodInfo(settings.getJatkoeraPituus(), true, i, ("E" + Integer.toString(overtime)), false, false, false, true);
                tmp.add(tmp_p);
                overtime = overtime + 1;
            }
            break_tmp = !break_tmp;
        }
            return tmp;
    }



    public ObservableValue<? extends String> getTimeFormat(LongProperty timeSMillis, boolean isPeriodPlay, Game gameTool) {
        ObservableBooleanValue boolean_tmp = timeSMillis.lessThanOrEqualTo(60000);
        StringExpression tmp;
        StringExpression a = Bindings.format("%02d:%02d.%01d", timeSMillis.divide(1000).divide(60), timeSMillis.divide(1000).subtract(timeSMillis.divide(1000).divide(60).multiply(60)), timeSMillis.divide(100).subtract(timeSMillis.divide(1000).subtract(timeSMillis.divide(1000).divide(60).multiply(60)).multiply(10)));
        StringExpression b = Bindings.format("%02d:%02d", timeSMillis.divide(1000).divide(60), timeSMillis.divide(1000).subtract(timeSMillis.divide(1000).divide(60).multiply(60)));
        if(isPeriodPlay){
            if(gameTool.getSettings().getKellonSuunta()){
                tmp = Bindings.when(boolean_tmp).then(a).otherwise(b);
            } else {
                boolean_tmp = timeSMillis.greaterThanOrEqualTo(1000L*gameTool.getPeriodInfo().seconds - 60000L);
                tmp = Bindings.when(boolean_tmp).then(a).otherwise(b);
            }

        } else {
            tmp = b;
        }
        return tmp;
    }
}
//            return Bindings.format("%02d:%02d", timeSMillis.divide(1000).divide(60), timeSMillis.divide(1000).subtract(timeSMillis.divide(1000).divide(60).multiply(60)));
//             return Bindings.format("%02d:%02d.%01d", timeSMillis.divide(1000).divide(60), timeSMillis.divide(1000).subtract(timeSMillis.divide(1000).divide(60).multiply(60)), timeSMillis.divide(100).subtract(timeSMillis.divide(1000).subtract(timeSMillis.divide(1000).divide(60).multiply(60)).multiply(10)));

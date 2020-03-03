package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Calculations {
     static boolean homeFoulsBusy = false;
     static boolean awayFoulsBusy = false;


    /**
     * Adds or Substracs X amount of points from the selected team and player.
     *
     * @param points            INT: How many points to add. Add negative numbers to substract.
     * @param isHome            BOOLEAN: Is the selected team home or away
     * @param xth_player        INT: Select right player to be manipulated.
     */
    public static void score_calculations(int points, boolean isHome, int xth_player, Game GameTool) {
        String[] scores = GameTool.SCORE.getValue().split("-", 5);
        xth_player = xth_player - 1;
        int PlayerScore = Integer.parseInt(GameTool.getPlayerPoints(isHome, xth_player));

        if (isHome) {
            int homeScore = Integer.parseInt(scores[0]);
            if(points + homeScore > -1 && PlayerScore + points > -1) {
                GameTool.setScore((homeScore + points) + "-" + scores[1]);
            }
        } else {
            int awayScore = Integer.parseInt(scores[1]);
            if(points + awayScore > -1 && PlayerScore + points > -1) {
                GameTool.setScore(scores[0] + "-" + (awayScore + points));
            }
        }
        if(PlayerScore + points > -1) {
            PlayerScore = PlayerScore + points;
            GameTool.setPlayerPoints((Integer.toString(PlayerScore)), isHome, xth_player);
        }
    }


    public static void foul_calculations(boolean adding, boolean isHome, int xth_player, Game GameTool) {
        int indexOfPlayer = xth_player - 1;

        if(adding){
            int tmp;
            if(isHome){
                homeFoulsBusy = true;
            } else {
                awayFoulsBusy = true;
            }
            tmp = Integer.parseInt(GameTool.getTeamFouls(isHome)) + 1;


            if(tmp <= GameTool.getSettings().getVirheetLkm()){
                if(isHome){
                    GameTool.HOME_FOULS.setValue(Integer.toString(tmp));
                } else {
                    GameTool.AWAY_FOULS.setValue(Integer.toString(tmp));
                }
            }
            if(-1 < xth_player && xth_player < 12) {
                if (GameTool.getPlayerFouls(isHome, indexOfPlayer).length() < 4) {
                    yellow_foul_set(indexOfPlayer, isHome, GameTool);
                } else if (GameTool.getPlayerFouls(isHome, indexOfPlayer).length() == 4 && GameTool.getPlayerRedFoul(isHome, indexOfPlayer).length() < 1) {
                    red_foul_set(indexOfPlayer, isHome, GameTool);
                }
            }



        } else {
            int tmp;
            tmp = Integer.parseInt(GameTool.getTeamFouls(isHome)) - 1;

            if (isHome) {
                if(tmp >= 0) {
                    GameTool.HOME_FOULS.setValue(Integer.toString(tmp));
                }
            } else {
                if(tmp >= 0) {
                    GameTool.AWAY_FOULS.setValue(Integer.toString(tmp));
                }
            }
            boolean isYellow;

            if (GameTool.getPlayerRedFoul(isHome, indexOfPlayer).length() == 1) {
                isYellow = false;
            } else {
                isYellow = true;
            }
            if (-1 < xth_player && xth_player < 12) {

                if (isYellow) {
                    int last = (GameTool.getPlayerFouls(isHome, indexOfPlayer).length() - 1);
                    GameTool.setPlayerFouls((GameTool.getPlayerFouls(isHome, indexOfPlayer).substring(0, last)), isHome, indexOfPlayer);
                } else {
                    int last = (GameTool.getPlayerRedFoul(isHome, indexOfPlayer).length() - 1);
                    GameTool.setPlayerRedFoul((GameTool.getPlayerFouls(isHome, indexOfPlayer).substring(0, last)), isHome, indexOfPlayer);

                }
            }
        }
    }

    private static void red_foul_set(int indexOfPlayer, boolean isHome, Game GameTool) {
        add_personal_foul(indexOfPlayer, isHome, false, GameTool);
        Timeline timelineblinkred = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {
            blinkRed(indexOfPlayer, isHome, GameTool);
        }));
        timelineblinkred.setCycleCount(10);
        timelineblinkred.playFromStart();
        timelineblinkred.setOnFinished(e -> {
            if (isHome) {
                homeFoulsBusy = false;
            } else {
                awayFoulsBusy = false;
            }
        });
    }

    private static void blinkRed(int indexOfPlayer, boolean isHome, Game GameTool) {
        if (1 == GameTool.getPlayerRedFoul(isHome, indexOfPlayer).length()) {
            substract_personal_foul(false, indexOfPlayer, isHome, GameTool);
        } else {
            add_personal_foul(indexOfPlayer, isHome, false, GameTool);
        }
    }


    private static void yellow_foul_set(int indexOfPlayer, boolean isHome, Game GameTool) {
        add_personal_foul(indexOfPlayer, isHome, true, GameTool);
        int tmpFouls = GameTool.getPlayerFouls(isHome, indexOfPlayer).length();
        Timeline timelineblinkyellow = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {
            blinkYellow(tmpFouls, indexOfPlayer, isHome, GameTool);
        }));
        timelineblinkyellow.setCycleCount(10);
        timelineblinkyellow.playFromStart();
        timelineblinkyellow.setOnFinished(e -> {
            if (isHome) {
                homeFoulsBusy = false;
            } else {
                awayFoulsBusy = false;
            }
        });
    }


    private static void blinkYellow(int correctFouls, int indexOfPlayer, boolean isHome, Game GameTool) {
        if (correctFouls == GameTool.getPlayerFouls(isHome, indexOfPlayer).length()) {
            substract_personal_foul(true, indexOfPlayer, isHome, GameTool);
        } else {
            add_personal_foul(indexOfPlayer, isHome, true, GameTool);
        }
    }

    private static void add_personal_foul(int indexOfPlayer, boolean isHome, boolean isYellow, Game GameTool) {
        String foul = "●";
        String tmp;
        if(isYellow){
                tmp = GameTool.getPlayerFouls(isHome, indexOfPlayer);
                GameTool.setPlayerFouls(tmp + foul, isHome, indexOfPlayer );
        } else {
            tmp = GameTool.getPlayerRedFoul(isHome, indexOfPlayer);
            GameTool.setPlayerRedFoul(tmp + foul, isHome, indexOfPlayer );
        }
    }

    public static void substract_personal_foul(boolean isYellow, int indexOfPlayer, boolean isHome, Game GameTool) {

        if(isYellow) {
            int last = (GameTool.getPlayerFouls(isHome, indexOfPlayer).length() - 1);
            if(last > -1) {
                GameTool.setPlayerFouls((GameTool.getPlayerFouls(isHome, indexOfPlayer).substring(0, last)), isHome, indexOfPlayer);
            }
        } else {
            int last = (GameTool.getPlayerRedFoul(isHome, indexOfPlayer).length() - 1);
            if(last > -1) {
                GameTool.setPlayerRedFoul((GameTool.getPlayerFouls(isHome, indexOfPlayer).substring(0, last)), isHome, indexOfPlayer);
            }

        }
    }

    public static void substract_personal_foul_any(int indexOfPlayer, boolean isHome, Game GameTool) {
        boolean isYellow;

        if(GameTool.getPlayerRedFoul(isHome, indexOfPlayer).length() == 1) {
            isYellow = false;
        } else {
            isYellow = true;
        }
        if(isYellow) {
            int last = (GameTool.getPlayerFouls(isHome, indexOfPlayer).length() - 1);
            GameTool.setPlayerFouls((GameTool.getPlayerFouls(isHome, indexOfPlayer).substring(0, last)), isHome, indexOfPlayer);
        } else {
            int last = (GameTool.getPlayerRedFoul(isHome, indexOfPlayer).length() - 1);
            GameTool.setPlayerRedFoul((GameTool.getPlayerFouls(isHome, indexOfPlayer).substring(0, last)), isHome, indexOfPlayer);

        }
    }

    public static void alternate_timeouts(boolean isAdding, boolean isHome, Game GameTool) {
        String tmp = "●";

        if(isAdding){
            if(isHome){
                if(GameTool.HOME_TIMEOUTS.getValue().length() < GameTool.getSettings().getAikalisaLkm()) {
                    GameTool.HOME_TIMEOUTS.setValue(GameTool.HOME_TIMEOUTS.getValue() + tmp);
                }
            } else {
                if(GameTool.AWAY_TIMEOUTS.getValue().length() < GameTool.getSettings().getAikalisaLkm()) {
                    GameTool.AWAY_TIMEOUTS.setValue(GameTool.AWAY_TIMEOUTS.getValue() + tmp);
                }
            }
        } else {
            if(isHome && GameTool.HOME_TIMEOUTS.getValue().length() > 0){
                int last = (GameTool.HOME_TIMEOUTS.getValue().length() - 1);
                GameTool.HOME_TIMEOUTS.setValue(GameTool.HOME_TIMEOUTS.getValue().substring(0, last));
            } else if( GameTool.AWAY_TIMEOUTS.getValue().length() > 0) {
                int last = (GameTool.AWAY_TIMEOUTS.getValue().length() - 1);
                GameTool.AWAY_TIMEOUTS.setValue(GameTool.AWAY_TIMEOUTS.getValue().substring(0, last));

            }
        }
    }


}

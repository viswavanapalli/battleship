package com.game.constants;

public class Constants {

    public static String[] bootstrapQueries = {
            "COMMAND=REGISTER_USER NAME=ADAM",
            "COMMAND=REGISTER_USER NAME=EVE",
            "COMMAND=CREATE_GAME PLAYER1_USER=1 PLAYER2_USER=2",
            "COMMAND=CREATE_SHIP PLAYER=1 GAME=1 ALIGNMENT=HORIZONTAL SHIP=CARRIER LOCATION=A1",
            "COMMAND=CREATE_SHIP PLAYER=1 GAME=1 ALIGNMENT=VERTICAL SHIP=BATTLESHIP LOCATION=B2",
            "COMMAND=CREATE_SHIP PLAYER=1 GAME=1 ALIGNMENT=HORIZONTAL SHIP=CRUISER LOCATION=D5",
            "COMMAND=CREATE_SHIP PLAYER=1 GAME=1 ALIGNMENT=VERTICAL SHIP=SUBMARINE LOCATION=E6",
            "COMMAND=CREATE_SHIP PLAYER=1 GAME=1 ALIGNMENT=HORIZONTAL SHIP=DESTROYER LOCATION=A7",
            "COMMAND=CREATE_SHIP PLAYER=2 GAME=1 ALIGNMENT=VERTICAL SHIP=CARRIER LOCATION=A4",
            "COMMAND=CREATE_SHIP PLAYER=2 GAME=1 ALIGNMENT=HORIZONTAL SHIP=BATTLESHIP LOCATION=B3",
            "COMMAND=CREATE_SHIP PLAYER=2 GAME=1 ALIGNMENT=VERTICAL SHIP=CRUISER LOCATION=C4",
            "COMMAND=CREATE_SHIP PLAYER=2 GAME=1 ALIGNMENT=HORIZONTAL SHIP=SUBMARINE LOCATION=D5",
            "COMMAND=CREATE_SHIP PLAYER=2 GAME=1 ALIGNMENT=VERTICAL SHIP=DESTROYER LOCATION=F7",
            "COMMAND=TARGET PLAYER=1 GAME=1 LOCATION=A4",
            "COMMAND=TARGET PLAYER=2 GAME=1 LOCATION=A1"
    };


}

package com.tekina.aggregation_composition;

public class Main {
    public static void main(String[] args){
        Player player1 = new Player("Virat Kohli");
        Player player2 = new Player("Rohit Sharma", "Captain");

        Team team1 = new Team("India");

        team1.addPlayer(player1);
        team1.addPlayer(player2);

        team1.displayPlayers();

        team1.removePlayer(player1.getPlayerId());

        System.out.println(team1);


        //        ---------------------------------------------------

        String[] roomTypes1 = {"Kitchen", "Bedroom"};
        House house1 = new House("Hemant Mishra", roomTypes1);

        House house2 = new House("Aniket Sharma");
        house2.addRoom("Powder Room");
        house2.addRoom("Master bedroom");

        house1.addRoom("Dining Room");

        house1.displayRooms();
        house2.displayRooms();

    }
}

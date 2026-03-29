package com.example.soccermanager.data.provider;

import com.example.soccermanager.data.models.Match;
import com.example.soccermanager.data.models.Player;
import com.example.soccermanager.data.models.Team;

import java.util.ArrayList;
import java.util.List;

public final class SampleDataFactory {

    private SampleDataFactory() {}

    public static List<Team> createSampleTeams() {
        List<Team> teams = new ArrayList<>();

        // Group A
        teams.add(new Team(1, "SE Palmeiras", "Brazil", "Brasileirão", "Allianz Parque", 1914));
        teams.add(new Team(2, "FC Porto", "Portugal", "Primeira Liga", "Estádio do Dragão", 1893));
        teams.add(new Team(3, "Al Ahly FC", "Egypt", "Egyptian Premier League", "Cairo International Stadium", 1907));
        teams.add(new Team(4, "Inter Miami CF", "United States", "MLS", "Chase Stadium", 2018));

        // Group B
        teams.add(new Team(5, "Paris Saint-Germain", "France", "Ligue 1", "Parc des Princes", 1970));
        teams.add(new Team(6, "Atlético de Madrid", "Spain", "La Liga", "Cívitas Metropolitano", 1903));
        teams.add(new Team(7, "Botafogo", "Brazil", "Brasileirão", "Nilton Santos Stadium", 1904));
        teams.add(new Team(8, "Seattle Sounders FC", "United States", "MLS", "Lumen Field", 2007));

        // Group C
        teams.add(new Team(9, "FC Bayern München", "Germany", "Bundesliga", "Allianz Arena", 1900));
        teams.add(new Team(10, "Auckland City FC", "New Zealand", "NZ National League", "Kiwitea Street", 1970));
        teams.add(new Team(11, "CA Boca Juniors", "Argentina", "Primera División", "La Bombonera", 1905));
        teams.add(new Team(12, "SL Benfica", "Portugal", "Primeira Liga", "Estádio da Luz", 1904));

        // Group D
        teams.add(new Team(13, "CR Flamengo", "Brazil", "Brasileirão", "Maracanã", 1895));
        teams.add(new Team(14, "Espérance Sportive de Tunis", "Tunisia", "Ligue Professionnelle 1", "Stade Hammadi Agrebi", 1919));
        teams.add(new Team(15, "Chelsea FC", "England", "Premier League", "Stamford Bridge", 1905));
        teams.add(new Team(16, "Los Angeles FC", "United States", "MLS", "BMO Stadium", 2014));

        // Group E
        teams.add(new Team(17, "CA River Plate", "Argentina", "Primera División", "El Monumental", 1901));
        teams.add(new Team(18, "Urawa Red Diamonds", "Japan", "J1 League", "Saitama Stadium 2002", 1950));
        teams.add(new Team(19, "CF Monterrey", "Mexico", "Liga MX", "Estadio BBVA", 1945));
        teams.add(new Team(20, "FC Internazionale Milano", "Italy", "Serie A", "San Siro", 1908));

        // Group F
        teams.add(new Team(21, "Fluminense FC", "Brazil", "Brasileirão", "Maracanã", 1902));
        teams.add(new Team(22, "Borussia Dortmund", "Germany", "Bundesliga", "Signal Iduna Park", 1909));
        teams.add(new Team(23, "Ulsan HD", "South Korea", "K League 1", "Ulsan Munsu Football Stadium", 1983));
        teams.add(new Team(24, "Mamelodi Sundowns FC", "South Africa", "Premier Division", "Loftus Versfeld Stadium", 1970));

        // Group G
        teams.add(new Team(25, "Manchester City", "England", "Premier League", "Etihad Stadium", 1880));
        teams.add(new Team(26, "Wydad AC", "Morocco", "Botola Pro", "Stade Mohammed V", 1937));
        teams.add(new Team(27, "Al Ain FC", "United Arab Emirates", "UAE Pro League", "Hazza bin Zayed Stadium", 1968));
        teams.add(new Team(28, "Juventus FC", "Italy", "Serie A", "Allianz Stadium", 1897));

        // Group H
        teams.add(new Team(29, "Real Madrid C.F.", "Spain", "La Liga", "Santiago Bernabéu", 1902));
        teams.add(new Team(30, "Al Hilal", "Saudi Arabia", "Saudi Pro League", "King Fahd International Stadium", 1957));
        teams.add(new Team(31, "CF Pachuca", "Mexico", "Liga MX", "Estadio Hidalgo", 1901));
        teams.add(new Team(32, "FC Salzburg", "Austria", "Austrian Bundesliga", "Red Bull Arena", 1933));

        return teams;
    }

    public static List<Player> createSamplePlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Lionel Messi", 25, "Argentina", "Forward", "FC Barcelona", 10));
        players.add(new Player(2, "Cristiano Ronaldo", 27, "Portugal", "Forward", "Real Madrid", 7));
        players.add(new Player(3, "Andrés Iniesta", 28, "Spain", "Midfielder", "FC Barcelona", 8));
        players.add(new Player(4, "Xavi Hernández", 32, "Spain", "Midfielder", "FC Barcelona", 6));
        players.add(new Player(5, "Radamel Falcao", 26, "Colombia", "Forward", "Atlético Madrid", 9));
        players.add(new Player(6, "Iker Casillas", 31, "Spain", "Goalkeeper", "Real Madrid", 1));
        players.add(new Player(7, "Andrea Pirlo", 33, "Italy", "Midfielder", "Juventus", 21));
        players.add(new Player(8, "Zlatan Ibrahimović", 31, "Sweden", "Forward", "Paris Saint-Germain", 10));
        players.add(new Player(9, "Robin van Persie", 29, "Netherlands", "Forward", "Manchester United", 20));
        players.add(new Player(10, "Yaya Touré", 29, "Ivory Coast", "Midfielder", "Manchester City", 42));
        players.add(new Player(11, "Neymar Jr.", 20, "Brazil", "Forward", "Santos", 11));
        players.add(new Player(12, "Sergio Agüero", 24, "Argentina", "Forward", "Manchester City", 16));
        players.add(new Player(13, "Mesut Özil", 24, "Germany", "Midfielder", "Real Madrid", 10));
        players.add(new Player(14, "Manuel Neuer", 26, "Germany", "Goalkeeper", "Bayern Munich", 1));
        players.add(new Player(15, "Didier Drogba", 34, "Ivory Coast", "Forward", "Chelsea", 11));
        return players;
    }

    public static List<Match> createSampleMatches() {
        List<Match> matches = new ArrayList<>();

        matches.add(new Match(1, "Barcelona", "Manchester United", "3-1", "Champions League", "2011-05-28", "Wembley Stadium"));
        matches.add(new Match(2, "Chelsea", "Bayern Munich", "1-1 (4-3 pens)", "Champions League", "2012-05-19", "Allianz Arena"));
        matches.add(new Match(3, "Bayern Munich", "Borussia Dortmund", "2-1", "Champions League", "2013-05-25", "Wembley Stadium"));
        matches.add(new Match(4, "Real Madrid", "Atlético Madrid", "4-1 AET", "Champions League", "2014-05-24", "Estádio da Luz"));
        matches.add(new Match(5, "Barcelona", "Juventus", "3-1", "Champions League", "2015-06-06", "Olympiastadion Berlin"));
        matches.add(new Match(6, "Real Madrid", "Atlético Madrid", "1-1 (5-3 pens)", "Champions League", "2016-05-28", "San Siro"));
        matches.add(new Match(7, "Real Madrid", "Juventus", "4-1", "Champions League", "2017-06-03", "Millennium Stadium"));
        matches.add(new Match(8, "Real Madrid", "Liverpool", "3-1", "Champions League", "2018-05-26", "NSC Olimpiyskiy"));
        matches.add(new Match(9, "Liverpool", "Tottenham", "2-0", "Champions League", "2019-06-01", "Wanda Metropolitano"));
        matches.add(new Match(10, "Bayern Munich", "Paris Saint-Germain", "1-0", "Champions League", "2020-08-23", "Estádio da Luz"));
        matches.add(new Match(11, "Chelsea", "Manchester City", "1-0", "Champions League", "2021-05-29", "Estádio do Dragão"));
        matches.add(new Match(12, "Real Madrid", "Liverpool", "1-0", "Champions League", "2022-05-28", "Stade de France"));
        matches.add(new Match(13, "Manchester City", "Inter Milan", "1-0", "Champions League", "2023-06-10", "Atatürk Olympic Stadium"));
        matches.add(new Match(14, "Real Madrid", "Borussia Dortmund", "2-0", "Champions League", "2024-06-01", "Wembley Stadium"));
        matches.add(new Match(15, "Paris Saint-Germain", "Inter Milan", "3-0", "Champions League", "2025-05-31", "Allianz Arena"));

        return matches;
    }
}
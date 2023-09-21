

class Project {

    private Long projectId;
}

class InvestmentInfo {
    private Project project;
}

class Activity {
    private Long activityId;

    private Project project;

}

class Concert {
    private Long concertId;

    private Project project;
}
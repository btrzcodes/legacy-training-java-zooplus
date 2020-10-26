package team.codium.legacytraining;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UsersStaticWebPageGenerator {
    public void generateFile(List<User> users) {
        // save resulting static html page
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("html/users.html");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("<!doctype html>");
            printWriter.println("<html lang=\"en\">");
            printWriter.println("<head>");
            printWriter.println("<meta charset=\"utf-8\">");
            printWriter.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");

            printWriter.println("<title>User biographies</title>");

            printWriter.println("<!-- Bootstrap core CSS -->");
            printWriter.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\" integrity=\"sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4\" crossorigin=\"anonymous\">");

            printWriter.println("<!-- Custom styles for this template -->");
            printWriter.println("<link href=\"assets/cover.css\" rel=\"stylesheet\">");
            printWriter.println("</head>");

            printWriter.println("<body class=\"text-center\">");

            printWriter.println("<div class=\"cover-container d-flex w-100 h-100 p-3 mx-auto flex-column\">");
            printWriter.println("<header class=\"masthead mb-auto\">");
            printWriter.println("<div class=\"inner\">");
            printWriter.println("<h3 class=\"masthead-brand\">Users Biography</h3>");
            printWriter.println("<nav class=\"nav nav-masthead justify-content-center\">");
            printWriter.println("<a class=\"nav-link active\" href=\"#\">Home</a>");
            printWriter.println("<a class=\"nav-link\" href=\"#\">Features</a>");
            printWriter.println("<a class=\"nav-link\" href=\"#\">Contact</a>");
            printWriter.println("</nav>");
            printWriter.println("</div>");
            printWriter.println("</header>");

            printWriter.println("<main role=\"main\" class=\"inner cover\">");
            for(User user: users) {
                printWriter.printf("<h1 class=\"cover-heading\">%s</h1>\n", user.getName());
                printWriter.printf("<p class=\"lead\">%s</p>\n", user.getBiography());
                showScore(printWriter, user);
            }
            printWriter.println("</main>");

            printWriter.println("<footer class=\"mastfoot mt-auto\">");
            printWriter.println("<div class=\"inner\">");
            printWriter.println("<p>Sprout class kata created by Codium <a href=\"https://twitter.com/CodiumTeam\">@CodiumTeam</a>. Cover template for <a href=\"https://getbootstrap.com/\">Bootstrap</a>, by <a href=\"https://twitter.com/mdo\">@mdo</a>.</p>");
            printWriter.println("</div>");
            printWriter.println("</footer>");
            printWriter.println("</div>");

            printWriter.println("<!-- Bootstrap core JavaScript");
            printWriter.println("        ================================================== -->");
            printWriter.println("<!-- Placed at the end of the document so the pages load faster -->");
            printWriter.println("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>");
            printWriter.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js\" integrity=\"sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ\" crossorigin=\"anonymous\"></script>");
            printWriter.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js\" integrity=\"sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm\" crossorigin=\"anonymous\"></script>");
            printWriter.println("</body>");
            printWriter.println("</html>");

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showScore(PrintWriter printWriter, User user) {
        printWriter.printf("<button type=\"button\" class=\"btn btn-warning\">Score <span class=\"badge badge-light\">%s</span><span class=\"sr-only\">keywords found</span></button>", user.getScore());
    }
}

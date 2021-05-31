package ua.lviv.iot.kasaraba.view;

import ua.lviv.iot.kasaraba.controller.Implementation.*;
import ua.lviv.iot.kasaraba.model.*;


import java.sql.SQLException;
import java.util.*;

public class MyView {
    private final ApplicationController applicationController = new ApplicationController();
    private final AuthorController authorController = new AuthorController();
    private final FeedbackController feedbackController = new FeedbackController();
    private final OrganizationController organizationController = new OrganizationController();
    private final SingleDeveloperController developerController = new SingleDeveloperController();
    private final UserController userController = new UserController();
    private final VersionUpdateController versionUpdateController = new VersionUpdateController();
    private final VirtualWalletController virtualWalletController = new VirtualWalletController();

    private static final Scanner input = new Scanner(System.in, "UTF-8");
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;

    public MyView() {
        menu = new LinkedHashMap<>();
        menu.put("1", "  01 - print all applications");
        menu.put("2", "  02 - get application by id");
        menu.put("3", "  03 - delete application by id");
        menu.put("4", "  04 - update application by id");
        menu.put("5", "  05 - add new application");

        menu.put("11", "  \n  11 - print all authors");
        menu.put("12", "  12 - get author by id");
        menu.put("13", "  13 - delete author by id");
        menu.put("14", "  14 - update author by id");
        menu.put("15", "  15 - add new author");

        menu.put("21", "  \n  21 - print all feedbacks");
        menu.put("22", "  22 - get feedback by id");
        menu.put("23", "  23 - delete feedback by id");
        menu.put("24", "  24 - update feedback by id");
        menu.put("25", "  25 - add new feedback");

        menu.put("31", "  \n  31 - print all organizations");
        menu.put("32", "  32 - get organization by id");
        menu.put("33", "  33 - delete organization by id");
        menu.put("34", "  34 - update organization by id");
        menu.put("35", "  35 - add new organization");

        menu.put("41", "  \n  41 - print all single developers");
        menu.put("42", "  42 - get single developer by id");
        menu.put("43", "  43 - delete single developer by id");
        menu.put("44", "  44 - update single developer by id");
        menu.put("45", "  45 - add new single developer");

        menu.put("51", "  \n  51 - print all users");
        menu.put("52", "  52 - get user by id");
        menu.put("53", "  53 - delete user by id");
        menu.put("54", "  54 - update user by id");
        menu.put("55", "  55 - add new user");

        menu.put("61", "  \n  61 - print all version updates");
        menu.put("62", "  62 - get version update by id");
        menu.put("63", "  63 - delete version update by id");
        menu.put("64", "  64 - update version update by id");
        menu.put("65", "  65 - add version update user");

        menu.put("71", "  \n  71 - print all virtual wallets");
        menu.put("72", "  72 - get virtual wallet by id");
        menu.put("73", "  73 - delete virtual wallet by id");
        menu.put("74", "  74 - update virtual wallet by id");
        menu.put("75", "  75 - add virtual wallet");


        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::printAllApplications);
        methodsMenu.put("2", this::printApplicationById);
        methodsMenu.put("3", this::deleteApplicationById);
        methodsMenu.put("4", this::updateApplicationById);
        methodsMenu.put("5", this::addApplication);

        methodsMenu.put("11", this::printAllAuthors);
        methodsMenu.put("12", this::printAuthorById);
        methodsMenu.put("13", this::deleteAuthorById);
        methodsMenu.put("14", this::updateAuthorById);
        methodsMenu.put("15", this::addAuthor);

        methodsMenu.put("21", this::printAllFeedbacks);
        methodsMenu.put("22", this::printFeedbackById);
        methodsMenu.put("23", this::deleteFeedbackById);
        methodsMenu.put("24", this::updateFeedbackById);
        methodsMenu.put("25", this::addFeedback);

        methodsMenu.put("31", this::printAllOrganizations);
        methodsMenu.put("32", this::printOrganizationById);
        methodsMenu.put("33", this::deleteOrganizationById);
        methodsMenu.put("34", this::updateOrganizationById);
        methodsMenu.put("35", this::addOrganization);

        methodsMenu.put("41", this::printAllSingleDevelopers);
        methodsMenu.put("42", this::printSingleDeveloperById);
        methodsMenu.put("43", this::deleteSingleDeveloperById);
        methodsMenu.put("44", this::updateSingleDeveloperById);
        methodsMenu.put("45", this::addSingleDeveloper);

        methodsMenu.put("51", this::printAllUsers);
        methodsMenu.put("52", this::printUserById);
        methodsMenu.put("53", this::deleteUserById);
        methodsMenu.put("54", this::updateUserById);
        methodsMenu.put("55", this::addUser);

        methodsMenu.put("61", this::printAllVersionUpdates);
        methodsMenu.put("62", this::printVersionUpdateById);
        methodsMenu.put("63", this::deleteVersionUpdateById);
        methodsMenu.put("64", this::updateVersionUpdateById);
        methodsMenu.put("65", this::addVersionUpdate);

        methodsMenu.put("71", this::printAllVirtualWallets);
        methodsMenu.put("72", this::printVirtualWalletById);
        methodsMenu.put("73", this::deleteVirtualWalletById);
        methodsMenu.put("74", this::updateVirtualWalletById);
        methodsMenu.put("75", this::addVirtualWallet);
    }

    private void printAllApplications() throws SQLException {
        System.out.println("\nTable: application");
        for (Application application : applicationController.getAll()) {
            System.out.println(application);
        }
    }

    private void printApplicationById() throws SQLException {
        System.out.println("Enter id of application ");
        int id = input.nextInt();
        System.out.println("Found application by id " + id);
        System.out.println(applicationController.getById(id));
    }

    private void deleteApplicationById() throws SQLException {
        System.out.println("Enter id of application");
        int id = input.nextInt();
        System.out.println("Rows updated: " + applicationController.delete(id));
    }

    private void updateApplicationById() throws SQLException {
        System.out.println("Enter id of application: ");
        int id = input.nextInt();
        System.out.println("Enter new name for application: ");
        String name = input.next();
        System.out.println("Enter new author id for application: ");
        int authorId = input.nextInt();
        System.out.println("Enter new release year id for application: ");
        int releaseYear = input.nextInt();
        System.out.println("Enter new price in dollars for application: ");
        int priceInDol = input.nextInt();
        Application entity = new Application(id, name, authorId, releaseYear, priceInDol);
        System.out.println("Rows updated: " +
                applicationController.update(entity));
    }

    private void addApplication() throws SQLException {
        System.out.println("Enter name for application: ");
        String name = input.next();
        System.out.println("Enter author id for application: ");
        int authorId = input.nextInt();
        System.out.println("Enter release year id for application: ");
        int releaseYear = input.nextInt();
        System.out.println("Enter price in dollars for application: ");
        int priceInDol = input.nextInt();
        Application entity = new Application(name, authorId, releaseYear, priceInDol);
        System.out.println("Rows updated: " +
                applicationController.add(entity));
    }

    private void printAllAuthors() throws SQLException {
        System.out.println("\nTable: author");
        for (Author author : authorController.getAll()) {
            System.out.println(author);
        }
    }

    private void printAuthorById() throws SQLException {
        System.out.println("Enter id of author");
        int id = input.nextInt();
        System.out.println("Found author by id " + id);
        System.out.println(authorController.getById(id));
    }

    private void deleteAuthorById() throws SQLException {
        System.out.println("Enter id of author");
        int id = input.nextInt();
        System.out.println("Rows updated: " + authorController.delete(id));
    }

    private void updateAuthorById() throws SQLException {
        Author entity = new Author();
        System.out.println("There are no attributes to update in author table");
        System.out.println("Rows updated: " + authorController.update(entity));
    }

    private void addAuthor() throws SQLException {
        System.out.println("Adding new author... ");
        Author entity = new Author();
        System.out.println("Rows updated: " + authorController.add(entity));
    }

    private void printAllFeedbacks() throws SQLException {
        System.out.println("\nTable: feedback");
        for (Feedback feedback : feedbackController.getAll()) {
            System.out.println(feedback);
        }
    }

    private void printFeedbackById() throws SQLException {
        System.out.println("Enter id of feedback");
        int id = input.nextInt();
        System.out.println("Found feedback by id " + id);
        System.out.println(feedbackController.getById(id));
    }

    private void deleteFeedbackById() throws SQLException {
        System.out.println("Enter id of feedback");
        int id = input.nextInt();
        System.out.println("Rows updated: " + feedbackController.delete(id));
    }

    private void updateFeedbackById() throws SQLException {
        System.out.println("Enter application id for feedback: ");
        int id = input.nextInt();
        System.out.println("Enter new feedback id: ");
        int application_id = input.nextInt();
        System.out.println("Enter new user id for feedback: ");
        int user_id = input.nextInt();
        System.out.println("Enter new stars given year id for feedback: ");
        int stars_given = input.nextInt();
        System.out.println("Enter new text feedback for feedback: ");
        String text_feedback = input.next();
        System.out.println("Would you recommend the app? 0-No, 1-Yes: ");
        int would_recommend = input.nextInt();
        Feedback entity = new Feedback(id, application_id, user_id, stars_given, text_feedback, would_recommend);
        System.out.println("Rows updated: " +
                feedbackController.update(entity));
    }

    private void addFeedback() throws SQLException {
        System.out.println("Enter application id for feedback: ");
        int application_id = input.nextInt();
        System.out.println("Enter user id for feedback: ");
        int user_id = input.nextInt();
        System.out.println("Enter stars given year id for feedback: ");
        int stars_given = input.nextInt();
        System.out.println("Enter text feedback for feedback: ");
        String text_feedback = input.next();
        System.out.println("Would you recommend the app? 0-No, 1-Yes: ");
        int would_recommend = input.nextInt();
        Feedback entity = new Feedback(application_id, user_id, stars_given, text_feedback, would_recommend);
        System.out.println("Rows updated: " +
                feedbackController.add(entity));
    }

    private void printAllSingleDevelopers() throws SQLException {
        System.out.println("\nTable: Single Developer");
        for (SingleDeveloper developer : developerController.getAll()) {
            System.out.println(developer);
        }
    }

    private void printSingleDeveloperById() throws SQLException {
        System.out.println("EEnter author id for developer");
        int id = input.nextInt();
        System.out.println("Found single developer by id " + id);
        System.out.println(developerController.getById(id));
    }

    private void deleteSingleDeveloperById() throws SQLException {
        System.out.println("Enter author id for developer");
        int id = input.nextInt();
        System.out.println("Rows updated: " + developerController.delete(id));
    }

    private void updateSingleDeveloperById() throws SQLException {
        System.out.println("Enter author id for developer: ");
        int authorId = input.nextInt();
        System.out.println("Enter new first name for single developer: ");
        String firstName = input.next();
        System.out.println("Enter new last name for single developer: ");
        String lastName = input.next();
        SingleDeveloper entity = new SingleDeveloper(firstName, lastName, authorId);
        System.out.println("Rows updated: " +
                developerController.update(entity));
    }

    private void addSingleDeveloper() throws SQLException {
        System.out.println("Enter author id for developer: ");
        int authorId = input.nextInt();
        System.out.println("Enter new first name for single developer: ");
        String firstName = input.next();
        System.out.println("Enter new last name for single developer: ");
        String lastName = input.next();
        SingleDeveloper entity = new SingleDeveloper(firstName, lastName, authorId);
        System.out.println("Rows updated: " +
                developerController.add(entity));
    }

    private void printAllUsers() throws SQLException {
        System.out.println("\nTable: user");
        for (User user : userController.getAll()) {
            System.out.println(user);
        }
    }

    private void printUserById() throws SQLException {
        System.out.println("Enter user id");
        int id = input.nextInt();
        System.out.println("Found user by id " + id);
        System.out.println(userController.getById(id));
    }

    private void deleteUserById() throws SQLException {
        System.out.println("Enter user id");
        int id = input.nextInt();
        System.out.println("Rows updated: " + userController.delete(id));
    }

    private void updateUserById() throws SQLException {
        System.out.println("Enter user id: ");
        int id = input.nextInt();
        System.out.println("Enter new first name for user: ");
        String firstName = input.next();
        System.out.println("Enter new last name for user: ");
        String lastName = input.next();
        System.out.println("Enter email for user: ");
        String email = input.next();
        System.out.println("Enter year of registration: ");
        int yearOfRegistration = input.nextInt();
        User entity = new User(id, firstName, lastName, email, yearOfRegistration);
        System.out.println("Rows updated: " +
                userController.update(entity));
    }

    private void addUser() throws SQLException {
        System.out.println("Enter new first name for user: ");
        String firstName = input.next();
        System.out.println("Enter new last name for user: ");
        String lastName = input.next();
        System.out.println("Enter email for user: ");
        String email = input.next();
        System.out.println("Enter year of registration: ");
        int yearOfRegistration = input.nextInt();
        User entity = new User(firstName, lastName, email, yearOfRegistration);
        System.out.println("Rows updated: " +
                userController.add(entity));
    }

    private void printAllVersionUpdates() throws SQLException {
        System.out.println("\nTable: Version Update");
        for (VersionUpdate versionUpdate : versionUpdateController.getAll()) {
            System.out.println(versionUpdate);
        }
    }

    private void printVersionUpdateById() throws SQLException {
        System.out.println("Enter id of version update");
        int id = input.nextInt();
        System.out.println("Found organization by author id " + id);
        System.out.println(versionUpdateController.getById(id));
    }

    private void deleteVersionUpdateById() throws SQLException {
        System.out.println("Enter id of version update: ");
        int id = input.nextInt();
        System.out.println("Rows updated: " + versionUpdateController.delete(id));
    }

    private void updateVersionUpdateById() throws SQLException {
        System.out.println("Enter id of version update: ");
        int id = input.nextInt();
        System.out.println("Enter new application id of version update: ");
        int applicationId = input.nextInt();
        System.out.println("Enter new things updated: ");
        String thingsUpdated = input.next();
        VersionUpdate entity = new VersionUpdate(id, applicationId, thingsUpdated);
        System.out.println("Rows updated: " +
                versionUpdateController.update(entity));
    }

    private void addVersionUpdate() throws SQLException {
        System.out.println("Enter new application id of version update: ");
        int applicationId = input.nextInt();
        System.out.println("Enter new things updated: ");
        String thingsUpdated = input.next();
        VersionUpdate entity = new VersionUpdate(applicationId, thingsUpdated);
        System.out.println("Rows updated: " +
                versionUpdateController.add(entity));
    }

    private void printAllVirtualWallets() throws SQLException {
        System.out.println("\nTable: virtual wallet");
        for (VirtualWallet virtualWallet : virtualWalletController.getAll()) {
            System.out.println(virtualWallet);
        }
    }

    private void printVirtualWalletById() throws SQLException {
        System.out.println("Enter id of virtual wallet");
        int id = input.nextInt();
        System.out.println("Found virtual wallet by id " + id);
        System.out.println(virtualWalletController.getById(id));
    }

    private void deleteVirtualWalletById() throws SQLException {
        System.out.println("Enter virtual wallet id of organization");
        int id = input.nextInt();
        System.out.println("Rows updated: " + virtualWalletController.delete(id));
    }

    private void updateVirtualWalletById() throws SQLException {
        System.out.println("Enter id of virtual wallet: ");
        int id = input.nextInt();
        System.out.println("Enter virtual wallet card number: ");
        String securedCardNumber = input.next();
        System.out.println("Enter new user id for virtual wallet: ");
        int userId = input.nextInt();
        System.out.println("Enter new balance in dol for virtual wallet: ");
        int balanceInDol = input.nextInt();
        VirtualWallet entity = new VirtualWallet(id, securedCardNumber, balanceInDol, userId);
        System.out.println("Rows updated: " +
                virtualWalletController.update(entity));
    }

    private void addVirtualWallet() throws SQLException {
        System.out.println("Enter user id for virtual wallet: ");
        int userId = input.nextInt();
        System.out.println("Enter virtual wallet card number: ");
        String securedCardNumber = input.next();
        System.out.println("Enter balance in dol for virtual wallet: ");
        int balanceInDol = input.nextInt();
        VirtualWallet entity = new VirtualWallet(securedCardNumber, balanceInDol, userId);
        System.out.println("Rows updated: " +
                virtualWalletController.add(entity));
    }

    private void printAllOrganizations() throws SQLException {
        System.out.println("\nTable: organization");
        for (Organization organization : organizationController.getAll()) {
            System.out.println(organization);
        }
    }

    private void printOrganizationById() throws SQLException {
        System.out.println("Enter author id of organization");
        int id = input.nextInt();
        System.out.println("Found organization by author id " + id);
        System.out.println(organizationController.getById(id));
    }

    private void deleteOrganizationById() throws SQLException {
        System.out.println("Enter author id of organization");
        int id = input.nextInt();
        System.out.println("Rows updated: " + organizationController.delete(id));
    }

    private void updateOrganizationById() throws SQLException {
        System.out.println("Enter author id of feedback: ");
        int author_id = input.nextInt();
        System.out.println("Enter new name for organization: ");
        String name = input.next();
        Organization entity = new Organization(name, author_id);
        System.out.println("Rows updated: " +
                organizationController.update(entity));
    }

    private void addOrganization() throws SQLException {
        System.out.println("Enter author id of organization: ");
        int author_id = input.nextInt();
        System.out.println("Enter name for organization: ");
        String name = input.next();
        Organization entity = new Organization(name, author_id);
        System.out.println("Rows updated: " +
                organizationController.add(entity));
    }


    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            while (keyMenu.equals("")) {
                keyMenu = input.nextLine().toUpperCase();
            }
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!keyMenu.equals("Q"));
    }
}


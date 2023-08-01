package ui.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import ui.elements.MainElements;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends MainElements {
    public MainPage openLoginPage() {
        open("http://localhost:80");
        return new MainPage();
    }

    public MainPage assertMainSectionIsOpened() {
        mainSection().shouldBe(Condition.visible);
        return this;
    }

    public MainPage createProject(String name, String identifier, String taskLimit) {
        createProjectButton().get(2).click();
        modalBox().shouldBe(Condition.visible);
        formName().sendKeys(name);
        formIdentifier().sendKeys(identifier);
        checkbox().click();
        taskLimit().sendKeys(taskLimit);
        save();
        return this;
    }

    public MainPage assertNewProjectIsCreated(String name) {
        panel().shouldBe(Condition.visible);
        dashboard().click();
        dashboardLinks().get(2).click();
        projectTitle().get(0).shouldHave(Condition.text(name));
        return this;
    }

    public MainPage createTask(String taskTitle) {
        projectTitle().get(0).click();
        dropdownMenu().click();
        createTaskButton().get(0).click();
        taskTitle().sendKeys(taskTitle);
        return this;
    }

    public MainPage assignToMe(String taskOwner) {
        assignToMeButton().click();
        taskOwner().shouldBe(Condition.text(taskOwner));
        return this;
    }

    public MainPage save() {
        scrollToElement(submit());
        submit().click();
        return this;

    }

    public MainPage assertNewTaskIsCreated(String assigneeName, String taskBoardTitle) {
        alert().shouldBe(Condition.visible);
        taskContainer().shouldBe(Condition.visible);
        taskList().get(0).getSize().equals(1);
        taskBoardAssignee().shouldBe(Condition.text(assigneeName));
        taskBoardTitle().shouldBe(Condition.text(taskBoardTitle));
        return this;
    }

    public MainPage addComment(String comment) {
        projectTitleList().get(0).click();
        taskDropdownMenu().get(0).click();
        addCommentButton().click();
        commentArea().sendKeys(comment);
        return this;
    }

    public MainPage assertNewCommentIsAdded(String comment) {

        commentInTaskContainer().get(0).shouldBe(Condition.visible);

        commentInTaskContainer().get(0).getAttribute("comment").contains(1 + " " + comment);
        return this;
    }

    public MainPage closeTask() {
        projectTitle().get(0).click();
        taskDropdownMenu().get(0).click();
        closeTaskButton().click();
        modalConfirmButton().click();
        return this;
    }

    public MainPage assertTaskIsClosed() {
        taskList().get(0).getSize().equals(0);
        return this;
    }

    public MainPage logout() {
        avatar().click();
        logoutButton().click();
        return this;
    }
}

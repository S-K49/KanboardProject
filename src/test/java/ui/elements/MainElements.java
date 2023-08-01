package ui.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainElements extends AbstractPageObject {

    public SelenideElement mainSection() {
        return $("#main");
    }

    public ElementsCollection createProjectButton() {
        return $$(By.xpath("//li/a[contains(@class, 'js-modal-medium')]"));
    }

    public SelenideElement modalBox() {
        return $("#modal-box");
    }

    public SelenideElement formName() {
        return $("#form-name");
    }

    public SelenideElement formIdentifier() {
        return $("#form-identifier");
    }

    public SelenideElement checkbox() {
        return $(By.xpath("//input[contains(@type, 'checkbox')]"));
    }

    public SelenideElement taskLimit() {
        return $("#form-task_limit");
    }

    public SelenideElement submit() {
        return $(By.xpath("//button[contains(@type, 'submit')]"));
    }

    public SelenideElement panel() {
        return $(".panel");
    }

    public SelenideElement dashboard() {
        return $(By.xpath("//a[contains(@title, 'Dashboard')]"));
    }

    public ElementsCollection dashboardLinks() {
        return $$(By.xpath("//li/a[contains(@href, '/dashboard')]"));
    }

    public ElementsCollection projectTitle() {
        return $$(".table-list-title");
    }

    public SelenideElement dropdownMenu() {
        return $(".dropdown-menu");
    }

    public ElementsCollection createTaskButton() {
        return $$(By.xpath("//div/a[contains(@href, '/task/create')]"));
    }

    public SelenideElement taskTitle() {
        return $("#form-title");
    }

    public SelenideElement assignToMeButton() {
        return $(".assign-me");
    }

    public SelenideElement taskOwner() {
        return $(By.xpath("//select[contains(@id, 'form-owner_id')]/option[2]"));
    }

    public SelenideElement alert() {
        return $(".alert");
    }

    public SelenideElement backlog() {
        return $(".board-column-1");
    }

    public SelenideElement taskContainer() {
        return $(".task-board-status-open");
    }

    public SelenideElement taskBoardAssignee() {
        return $(".task-board-assignee");
    }

    public SelenideElement taskBoardTitle() {
        return $(".task-board-title");
    }

    public ElementsCollection taskDropdownMenu() {
        return $$(By.xpath("//div[contains(@class, 'task-board-header')]/div/a[contains(@class, 'dropdown-menu')]"));
    }

    public SelenideElement addCommentButton() {
        return $(By.xpath("//ul[contains(@class, 'dropdown-submenu-open')]/li/a[contains(@href, 'comment/create')]"));
    }

    public SelenideElement commentArea() {
        return $(byName("comment"));
    }

    public ElementsCollection commentInTaskContainer() {
        return $$(byTitle("comment"));
    }

    public SelenideElement closeTaskButton() {
        return $(By.xpath("//div[contains(@id, 'dropdown')]/ul/li/a[contains(@href, '/close')]"));
    }

    public SelenideElement modalConfirmButton() {
        return $("#modal-confirm-button");
    }

    public ElementsCollection taskList() {
        return $$(".board-task-list");
    }

    public ElementsCollection projectTitleList() {
        return $$(By.xpath("//span[contains(@class, 'table-list-title ')]"));
    }

    public SelenideElement avatar() {
        return $(".avatar");
    }

    public SelenideElement logoutButton() {
        return $(By.xpath("//ul[contains(@class, 'dropdown-submenu-open')]/li/a[contains(@href, 'logout')]"));
    }

}

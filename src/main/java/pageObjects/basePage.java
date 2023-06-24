package pageObjects;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public class basePage {

	private By commonlogout = xpath("id=logout"); 

}

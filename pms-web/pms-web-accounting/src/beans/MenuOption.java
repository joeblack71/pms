/*
 * Option.java
 *
 * Created on December 11, 2006, 7:42 PM
 */

package beans;

/**
 *
 * @author  instructor
 * @version
 */
public class MenuOption implements java.io.Serializable{

    private short  menuId;
    private short  optionId;
    private String description;
    private short  resourceType;
    private String resourceName;
    private short  outputType; // 1=Screen; 2=Report
    private String resourceInfo;
    private String imageOption;

    /** Creates new MenuOption */
    public MenuOption() {
    }

    public short getMenuId() {
        return menuId;
    }
    public void setMenuId(short menuId) {
        this.menuId = menuId;
    }

    public short getOptionId() {
        return optionId;
    }
    public void setOptionId(short optionId) {
        this.optionId = optionId;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public short getResourceType() {
        return resourceType;
    }
    public void setResourceType(short resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceName() {
        return resourceName;
    }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public short getOutputType() {
        return outputType;
    }
    public void setOutputType(short outputType) {
        this.outputType = outputType;
    }

    public String getResourceInfo() {
        return resourceInfo;
    }
    public void setResourceInfo(String title) {
        this.resourceInfo = title;
    }

    public String getImageOption() {
        return imageOption;
    }
    public void setImageOption(String imageOption) {
        this.imageOption = imageOption;
    }

}

package tv.bgm.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class CustomPluginTest implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getExtensions().add("customPlugin", CustomPluginExtension);
        project.task("showPersonInfo") << {
            println("姓名:" + project.customPlugin.name)
            println("年龄:" + project.customPlugin.age)
            println("address:" + project.customPlugin.address)
        }
    }
}
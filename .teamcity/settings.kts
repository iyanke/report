import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.ProjectReportTab
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.buildReportTab
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.projectReportTab
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.2"

project {

    vcsRoot(HttpsGithubComIyankeBigdataRefsHeadsMaster)

    buildType(Config)

    features {
        projectReportTab {
            id = "PROJECT_EXT_115"
            title = "report2"
            startPage = "index.html"
            buildType = "${Config.id}"
            sourceBuildRule = ProjectReportTab.SourceBuildRule.LAST_SUCCESSFUL
        }
        buildReportTab {
            id = "PROJECT_EXT_117"
            title = "Report2"
            startPage = "android/index.html"
        }
    }
}

object Config : BuildType({
    name = "config"

    artifactRules = "**/index.html"

    vcs {
        root(HttpsGithubComIyankeBigdataRefsHeadsMaster)
    }
})

object HttpsGithubComIyankeBigdataRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/iyanke/bigdata#refs/heads/master"
    url = "https://github.com/iyanke/bigdata"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "iyanke"
        password = "credentialsJSON:7c44fbf5-6ed1-4ecb-ac02-060f37b97bf7"
    }
})

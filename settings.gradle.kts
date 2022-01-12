rootProject.name = "spotless-issue-1087"

for (i in 1..20) {
    include(":subproject$i")
}

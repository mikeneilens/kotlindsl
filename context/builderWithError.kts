build {
    version = "1.2"
    src = "/src"
    test = "/test"

    dependency("some.library")
    dependency("another.library")

    task("test") {
        jvmArgs = "-p somepath"
        dependency("**should.not.be.here**")
    }
}
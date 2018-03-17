def call(String credID, Closure body) {

    def config = [:]
    body.resolveStrategy = Closure.OWNER_FIRST
    body.delegate = config

    def usName
    def usPwd

    this.withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: "${credID}",
                      usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {

        usName = env.USERNAME
        usPwd = env.PASSWORD ? envVar.PASSWORD : '\"\"'
    }

    body(usName, usPwd)
//    true

}

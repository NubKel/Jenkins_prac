def pipelines = [
    [name: 'm4/demo2-1', scriptPath: '04/demo/demo2/2.1/Jenkinsfile'],
    [name: 'm4/demo2-2', scriptPath: '04/demo/demo2/2.2/Jenkinsfile']
]

for(p in pipelines) {
	pipelineJob("${p.name}") {
	    definition {
	        cpsScm {
	            scm {
	                git {
	                  remote {
	                    name('github')
	                    url('https://github.com/NubKel/Jenkins_prac.git')
	                  }
	                  branch('main')
	                  extensions {
	                  	cloneOptions {
	                  	  shallow(true)
	                  	  depth(1)
						  noTags(true)
	                  	}
	                  }
	                }
	            }
	            scriptPath("${p.scriptPath}")
	        }
	    }
	    triggers {
	        cron('H H(1-8) * * *')
	    }
	}
}

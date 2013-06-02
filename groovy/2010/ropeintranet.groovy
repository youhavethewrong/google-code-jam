/* Calculate the intersection points of a rope intranet.
 *
 */

def intersections(links) {
    def intersectionCount = 0
    for(def l=0; l < links.size(); l++) {
        for(def m=0; m < links.size(); m++) {
            if(links[l]['linkA'] != links[m]['linkA'] &&
               links[l]['linkB'] != links[m]['linkB']) {
                if(links[l]['linkA'] < links[m]['linkA'] &&
                   links[m]['linkA'] < links[l]['linkB']) {
                    intersectionCount++
                }
                else if(links[l]['linkA'] < links[m]['linkB'] &&
                        links[m]['linkB'] < links[l]['linkB']) {
                    intersectionCount++
                }
            }
        }
    }

    return intersectionCount
}

def main() {
    def fh = new File(args[0])
    def lines = fh.readLines()
    def caseCount = Integer.valueOf(lines[0])
    def index = 1;
    
    for(def i=0; i < caseCount; i++) {
        def links = [:]
        def linkCount = Integer.valueOf(lines[index])

        for(def j=1; j <= linkCount; j++) {
            def endPoints = lines[index+j].split(" ")
            def linkA = endPoints[0]
            def linkB = endPoints[1]
            links[(j-1)] = [linkA:Integer.valueOf(linkA), linkB:Integer.valueOf(linkB)]
        }

        println "Case #"+(i+1)+":"+intersections(links)
        index += linkCount+1
    }
}

main()

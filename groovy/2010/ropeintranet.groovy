/* Calculate the intersection points of a rope intranet.
 *
 */

def getSlope(x1, y1, x2, y2) {
    return (y2 - y1)/(x2 - x1)
}

def getIntercept(x, y, slope) {
    return y - slope*x
}

def intersections(links) {
    def intersectionCount = 0
    def lines = [:]
    for(def i=0; i < links.size(); i++) {
        def x1 = 0
        def y1 = links[i][0]
        def x2 = 1
        def y2 = links[i][1]
        def slope = getSlope(x1, y1, x2, y2)
        def intercept = getIntercept(x1, y1, slope)
        lines[i] = [x1:x1, y1:y1, x2:x2, y2:y2, slope:slope, intercept:intercept]
    }
    //println lines

    for(def i=0; i < lines.size(); i++) {
        for(def j=0; j < lines.size(); j++) {
            if( i != j ) {
                def b = lines[j]["intercept"] - lines[i]["intercept"]
                def m = lines[i]["slope"] - lines[j]["slope"]
                if(m != 0 && b > 0) {
                    def xCoord = b/m
                    if(xCoord >= 0 && xCoord <= 1) {
                        //println "Intersection at ("+xCoord+","+b+")"
                        intersectionCount++
                    }
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
            links[(j-1)] = [0:Integer.valueOf(linkA), 1:Integer.valueOf(linkB)]
        }

        println "Case #"+(i+1)+": "+intersections(links)
        index += linkCount+1
    }
}

main()

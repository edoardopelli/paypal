#/bin/sh!
mvn17 -B release:prepare-with-pom -DdryRun=true  -Darguments="-DskipTests -Dmaven.javadoc.skip=true"
if [ $? -eq 0 ]; then
    mvn21 -f pom.xml.tag clean install -DskipTests
	export REPO=$(mvn21 -q -f pom.xml.tag -Dexec.executable=echo  -Dexec.args='${project.artifactId}' --non-recursive exec:exec)
	echo REPO=$REPO 
	export VERSION=$(mvn21 -q -f pom.xml.tag -Dexec.executable=echo  -Dexec.args='${project.version}' --non-recursive exec:exec)
	echo VERSION=$VERSION
    export TAG=$REPO-$VERSION
    git tag -a $TAG -m "version $TAG"
    git push origin $TAG
	export USER=setupnet
	echo USER=$USER
	echo $VERSION
	docker build --build-arg version=$VERSION -t $USER/$REPO:$VERSION .
	if [ $? -eq 0 ]; then
		docker push $USER/$REPO:$VERSION
	fi
	docker build -t  $USER/$REPO:latest --build-arg version=$VERSION .
        if [ $? -eq 0 ]; then
                docker push $USER/$REPO:latest
        fi

fi
if [ $? -eq 0 ]; then
    mv pom.xml.next pom.xml
    git commit -m "change snapshot version to next" .
    git push
    rm pom.xml.next
    rm pom.xml.releaseBackup
    rm pom.xml.tag
    rm release-pom.xml
    rm release.properties
fi



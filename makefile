JFLAGS = -g
JC = javac
.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	craneSim/BlockView.java \
	craneSim/BlockWorld.java \
	craneSim/Crane.java \
	craneSim/CraneSim.java \
	craneSim/Displayable.java \
	craneSim/CraneView.java \
	craneSim/DisplayableObject.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
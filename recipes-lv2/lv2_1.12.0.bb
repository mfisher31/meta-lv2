# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
DEPENDS += "python"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=0383f162366b0c5a316292759a55d292"

SRC_URI = "http://lv2plug.in/spec/lv2-${PV}.tar.bz2"
SRC_URI[md5sum] = "665580dc761de40b0d335001a204496a"
SRC_URI[sha256sum] = "7a4a53138f10ed997174c8bc5a8573d5f5a5d8441aaac2de6cf2178ff90658e9"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
FILES_${PN} = "${libdir} ${bindir} ${sharedir}"

do_configure () {
	./waf configure --prefix="${prefix}"
}

do_compile () {
	./waf build
}

do_install () {
	./waf ${WAF_VERBOSE} install --destdir="${D}" "$@"
}


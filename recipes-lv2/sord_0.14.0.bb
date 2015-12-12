# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
DEPENDS = "serd"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=9f6de02da791b5def4aa51ea92a6fc94"

# No information for SRC_URI yet (only an external source tree was specified)
SRC_URI = "http://download.drobilla.net/sord-0.14.0.tar.bz2"
SRC_URI[md5sum] = "7ffda283ad0a5716f196f650edd25713"
SRC_URI[sha256sum] = "7656d8ec56a43e0f0a168fe78670a7628a42d3a597b53c7a72ac243a74e0f19a"

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

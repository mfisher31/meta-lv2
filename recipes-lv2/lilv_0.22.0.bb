# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
DEPENDS += "serd sord sratom"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=9f6de02da791b5def4aa51ea92a6fc94"

SRC_URI = "http://download.drobilla.net/lilv-0.22.0.tar.bz2"
SRC_URI[md5sum] = "fd3a14fdaeaba4716b4fef526548a747"
SRC_URI[sha256sum] = "cd279321223ef11ca01551767d3c16d68cb31f689e02320a0b2e37b4f7d17ab4"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
FILES_${PN} = "${libdir} ${bindir} ${sharedir} /usr/etc/bash_completion.d/lilv"

do_configure () {
	./waf configure --prefix="${prefix}"
}

do_compile () {
	./waf build
}

do_install () {
	./waf ${WAF_VERBOSE} install --destdir="${D}" "$@"
}

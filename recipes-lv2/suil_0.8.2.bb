# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
DEPENDS += "serd sord sratom"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=afebf9b26e5565d15d2b2b76600d94b7"

SRC_URI = "http://download.drobilla.net/suil-0.8.2.tar.bz2"
SRC_URI[md5sum] = "1b06947b1fc028f9ffcbc16d30065aa5"
SRC_URI[sha256sum] = "787608c1e5b1f5051137dbf77c671266088583515af152b77b45e9c3a36f6ae8"

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

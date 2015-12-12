# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
DEPENDS += "serd sord lv2"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=394d0c1b7157c45525c00dbf16afbe51"

# No information for SRC_URI yet (only an external source tree was specified)
SRC_URI = "http://download.drobilla.net/sratom-0.4.6.tar.bz2"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
FILES_${PN} = "${libdir} ${bindir} ${sharedir}"

SRC_URI[md5sum] = "5cf28520418779bf41fb14a40fbb20ad"
SRC_URI[sha256sum] = "a4b9beaeaedc4f651beb15cd1cfedff905b0726a9010548483475ad97d941220"

do_configure () {
	./waf configure --prefix="${prefix}"
}

do_compile () {
	./waf build
}

do_install () {
	./waf ${WAF_VERBOSE} install --destdir="${D}" "$@"
}

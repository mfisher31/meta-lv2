# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# NOTE: multiple licenses have been detected; if that is correct you should separate
# these in the LICENSE value using & if the multiple licenses all apply, or | if there
# is a choice between the multiple licenses. If in doubt, check the accompanying
# documentation to determine which situation is applicable.

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=098179317a3f5baebd89d1f37a98b7d8 \
                    file://tests/TurtleTests/LICENSE;md5=71c2a7ee99ad6f9b834cf6bc2dc2d636"

# No information for SRC_URI yet (only an external source tree was specified)
SRC_URI = "http://download.drobilla.net/serd-0.22.0.tar.bz2"
SRC_URI[md5sum] = "541bceb9f7cec50f4bf618060332b87c"
SRC_URI[sha256sum] = "7b030287b4b75f35e6212b145648bec0be6580cc5434caa6d2fe64a38562afd2"

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

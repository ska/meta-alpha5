SUMMARY = "Domoticz is a Home Automation system design to control various devices and receive input from various sensors. "

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://License.txt;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "curl openssl boost zlib python3"
RDEPENDS_${PN} = " curl python3"

inherit cmake pkgconfig useradd update-rc.d python-dir
DEPENDS = "curl openssl boost zlib python3"
RDEPENDS_${PN} = " curl python3"

PV = "3.8153+git${SRCPV}"
SRCREV = "494fff71685f319b25e7824684c299162b19f8c3"
SRC_URI = " git://github.com/domoticz/domoticz.git;protocol=https \
            file://domoticz.sh \
"

S = "${WORKDIR}/git"

EXTRA_OECMAKE = " -DBOOST_INCLUDEDIR=${STAGING_INCDIR} \
                  -DOPENSSL_INCLUDE_DIR=${STAGING_INCDIR} \
                  -DOPENSSL_LIBRARIES=${STAGING_LIBDIR} \
                  -DCURL_LIBRARIES=${STAGING_LIBDIR} \
                  -DCURL_INCLUDE_DIR=${STAGING_INCDIR} \
                  -DCMAKE_INSTALL_PREFIX=/home/domoticz \
                "

FILES_${PN}-dbg     += "${localstatedir}/lib/domoticz/.debug/"
FILES_${PN}         += "/home/domoticz/* ${sysconfdir}/init.d/domoticz.sh"
INITSCRIPT_NAME     =  "domoticz.sh"
INITSCRIPT_PARAMS   =  "defaults 80 70"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "-u 1200 -d /home/domoticz -r -s /bin/sh -P 'domoticz' -g domoticz domoticz"
GROUPADD_PARAM_${PN} = "-g 880 domoticz"

do_install_append () {
	mkdir -p ${D}/${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/domoticz.sh ${D}/${sysconfdir}/init.d
    chown -R domoticz ${D}/home/domoticz
    chgrp -R domoticz ${D}/home/domoticz
}

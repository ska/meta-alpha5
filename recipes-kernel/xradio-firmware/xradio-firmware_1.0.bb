DESCRIPTION = "XR819 FirmWare"
SECTION = "wifi"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = " file://xr819.tar.gz \
            file://COPYING.GPLv2 \
"

S = "${WORKDIR}/"

do_install(){
    mkdir -p ${D}/lib/firmware/xr819/
    cp ${S}/boot_xr819.bin ${D}/lib/firmware/xr819/ 
    cp ${S}/fw_xr819.bin ${D}/lib/firmware/xr819/
    cp ${S}/sdd_xr819.bin ${D}/lib/firmware/xr819/
}

FILES_${PN} = "/lib/firmware/xr819/"


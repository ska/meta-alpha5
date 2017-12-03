SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(opiz-sun)"

inherit kernel

require linux.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"
DEPENDS += " util-linux"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/git"
	
SRC_URI = "git://github.com/montjoie/linux.git;protocol=git;branch=dwmac-sun8i-current \
           file://0001-Added-Wifi.patch \
           file://defconfig \
"
SRCREV = "575e2c13a742899221689abba85f221f494761b4"

#KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} O=${B} ${KERNEL_MACHINE}_defconfig"


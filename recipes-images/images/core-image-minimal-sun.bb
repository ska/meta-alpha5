SUMMARY = "A small image just capable of allowing a device to boot."
DESCRIPTION = "A small image just capable of allowing a device to boot and \
is suitable for development work."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"
IMAGE_LINGUAS = " "
LICENSE = "MIT"
inherit core-image

IMAGE_ROOTFS_SIZE = "100000"

IMAGE_FEATURES_remove = "ssh-server-dropbear"
IMAGE_FEATURES += "ssh-server-openssh"

TOOLS = "\
    bash \
    htop \
    lsof \
    powertop \
    screen \
    socat \
    sysstat \
    evtest \
    i2c-tools \
    gdb \
    procps \
    strace \
    usbutils \
"

IMAGE_INSTALL += "\
    iproute2 \
    vim \
    openvpn \
    openssh-sftp-server \
    e2fsprogs \
    gdbserver \
    kernel-modules \
    ${TOOLS} \
"

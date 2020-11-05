SUMMARY = "A very basic Wayland image with a terminal"

IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs"

LICENSE = "MIT"

inherit core-image features_check

REQUIRED_DISTRO_FEATURES = "wayland"

WESTON_IMAGE = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'nexell-daudio-ref', '', \
	   bb.utils.contains('DISTRO_FEATURES', 'nexell-convergence-daudio', '', 'weston weston-init weston-examples', d), d)} \
"

CORE_IMAGE_BASE_INSTALL += "gtk+3-demo clutter-1.0-examples"
CORE_IMAGE_BASE_INSTALL += "${WESTON_IMAGE}"
CORE_IMAGE_BASE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal', '', d)}"

This file describes how to setup the Vagrant box, to make sure testing en running the necessary virtual machine works simply by executing a Maven command.

Make sure Ruby 1.9.2, Vagrant and VeeWee are installed (preferrably using RVM)

Steps:

1) Optionally place the necessary ISO file in the iso subdirectory. Otherwise it will be automatically downloaded.

2) Build the virtual box. Use '--force' to overwrite an existing install.
$ veewee vbox build 'debianbox'

3) Validate that the box was created successfully. (ignore Chef as we don't install it)
$ veewee vbox validate 'debianbox'

4) Shutdown VM, login with vagrant / vagrant.

5) Export the box (creates a '.box' file).
$ vagrant basebox export 'debianbox'

6) Import the box so that Vagrant can find it and can create instances.
$ vagrant box add 'debianbox' 'debianbox.box'

7) The git submodules should be loaded in the project (from git repo root)
$ git submodule update --init --recursive


Now you're all set to go. Normally you would need to init the Vagrant box but this is done already.

To separately run the VM, execute the following commands:
$ vagrant up
$ vagrant ssh

To reload (re-provision) the VM, execute the following command:
$ vagrant reload


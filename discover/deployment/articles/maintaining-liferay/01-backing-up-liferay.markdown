# Backing up Liferay

Once you've installed Liferay Portal, you should establish proper backup
procedures. Hopefully, you'll never encounter a catastrophic hardware failure
but you should always be prepared. Intrinsically, Liferay is no different from
any other application that you can run on your application server. Nevertheless,
there are some specific components you should include in your backup plan.

## Backing up Source Code

If you have extended Liferay or created any custom plugins, they should be
stored in a source code repository such as Git, Subversion, or CVS. (Unless
you're Linus Torvalds, and then tarballs are okay too. Just kidding.) Your
source code repository should be backed up on a regular basis to preserve your
ongoing work. This probably goes without saying in your organization. Nobody
wants to lose source code that's taken months to produce. Nevertheless, it's
important to remember source code in any kind of backup plan. 

Next, Let's look at the items that need to be backed up in your Liferay
installation. 

## Backing up Liferay's File System

Liferay's properties configuration files, `portal-ext.properties` and
`portal-setup-wizard.properties`, should be stored in the *Liferay Home* folder,
which is generally one folder up from where your application server is
installed. (See the [Installation and Setup]() (not yet written) section for
specific details for your application server.) At a minimum, these files should
be backed up. You should always back up your Liferay Home folder and it's best
to back up your entire application server.

If you followed the non-plugin procedure
([Modifying the Ehcache Settings Directly]()) (not yet written) to customize
your Ehcache configuration, you'll have cache configuration files in the
location to which Liferay was deployed in your application server. You'll need
to back up this location. If you followed the plugin procedure
([Modifying the Ehcache Settings Directly]()) (not yet written) to customize
your Ehcache configuration, your cache configuration settings should be stored
in your source code repository, which should be backed up separately. Note that
customizing your Ehcache settings with a plugin is the recommended method.

As mentioned above, you should back up the contents of your Liferay Home folder.
Liferay stores configuration files, search indexes, and cache information in a
sub-folder of Liferay Home called `data`. Backing up Liferay's search indexes is
important if you wish to avoid reindexing your entire portal after you perform a
restore. This is easy to do since Liferay uses Elastic Search and Elastic Search
stores its indexes in the `data` folder. If you're in a clustered configuration
and you're replicating indexes, you should back up each index replica. If you're
using the File System store or the Advanced File System store, Liferay's
documents and media repository is also stored in the `data` folder, by default.
If you've customized the location where the Document Library stores files, you
should back up the custom location.

Here's a summary of key folders and files to back up:

- Your Liferay Home folder
    - Your properties configuration files: `portal-ext.properties` and
      `portal-setup-wizard.properties`
    - Your `data` folder
- Your entire application server
- The location of your customized Ehcache configuration settings (if applicable)
- The location of your customized documents and media file store (if applicable)

That covers the file system locations used by Liferay. Next, let's discuss how
to back up Liferay's database.

## Backing up Liferay's Database

Liferay's database is the central repository for all of the portal's information
and is the most important component that needs to be backed up. You can do this
by backing up the database live (if your database allows this) or by exporting
the database and then backing up the exported file. For example, MySQL ships
with a `mysqldump` utility which allows you to export the entire database and
data into a large SQL file. This file can then be backed up. In case of a
database failure, this file can be used to recreate the state of the database at
the time the dump was created.

If you're using Liferay's Documents and Media Library with the Jackrabbit
JSR-170 repository to store documents in a database, the Jackrabbit database
should also be backed up. If you've placed your search indexes into a database,
that database should be backed up as well. Note: Placing your search index in a
database in not recommended and should not be necessary.

Restoring your application server, your Liferay Home folder, the locations of
any file system-based documents and media repositories, and your database from a
backup system should give you a functioning portal. Restoring search indexes
should avoid the need to reindex when you bring your site back up after a
catastrophic failure. Good, consistent backup procedures are key to successfully
recovering from a hardware failure. 

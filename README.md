jXero
=====

A simple Java library for the [Xero API](http://developer.xero.com/documentation/api/api-overview/).

[Download latest version](http://keithharris.org/jXero/jxero-latest.zip)

#### Easy to set up

Drop the jar on your classpath and you can run code like this to connect:

    String consumerKey = "JDFSDKGEN4567DFS9987DFSF993222";
    String consumerSecret = "87DFSF993222JDFSDKGEN4567DFS99";
    File privateKeyFile = new File("/path/to/your/privatekey.pem");
    XeroClient xero = new XeroClient(consumerKey, consumerSecret, privateKeyFile);

Or include a properties file alongside the jar for one line setup:

    XeroClient xero = new XeroClient(true);

Then use the method named after the Xero endpoint you want to use:

    Contact contact = xero.contacts().getByEmailAddress("test@example.com");
    Invoice invoice = xero.invoices().getByNumber("INV-0001");

#### Create a contact

    Contact contact = new Contact();
    contact.setName("Acme Ltd");
    contact.setEmailAddress("acme@example.com");

    xero.contacts().post(contact);

#### Grab a list of contacts

    String w = "EmailAddress.endsWith(\"gmail.com\")";
    List<Contact> contacts = xero.contacts().getContactsWhere(w);
    for (Contact contact : contacts) {
        System.out.println(contact.getEmailAddress());
    }

### No JAXB generated classes

The auto-generated classes that you get direct from JAXB can sometimes be a pain to work with.
We've tried to make the core business objects you need to work with as simple as possible.
You won't need to use a FactoryObject to pre-process the due date on your invoice - just build
like a normal bean and post through the client.

### Actively maintained and open for contributions

Here at [Softly Software Ltd](http://softlysoftware.com) we use Xero every day to handle all the 
transactions for our services. When it came time to plugin the servers to speak direct to our data
we looked around and couldn't find quite the right wrapper - so we built this one.

Bug reports, contributions and pull requests most welcome.

### Dependencies

 * [OAuth](https://code.google.com/p/oauth/)
 * [Commons Logging](http://commons.apache.org/proper/commons-logging/)
 * [Commons Codec](http://commons.apache.org/proper/commons-codec/)
 * [Commons HttpClient](http://hc.apache.org/httpclient-3.x/)
 * [Commons IO](http://commons.apache.org/proper/commons-io/)

### Frequently Asked Questions

 * **There's an enpoint or type of object missing - can you add it?**
   Perhaps, if we get enough requests. But please checkout the code - you probably only need to copy and
   paste from what is already there and make some simple changes. If you badly need something adding we 
   might be able to help you find a developer who will do it for a fee.

 * **Can it be used for Public as well as Private Xero Applications?**
   We don't know. So far the emphasis has all been about making it easy for Private Applications.
   If you have any success using this for a Public Application, please do let us know.

 * **What if a question isn't answered here?**
   Please get in touch. Email us at *jxero (that symbol) softlysoftware (that punctuation mark) com*

// by Szymon Krawczyk

package com.example.projekt_grupowy.Formats;

public abstract class RIS  extends Format {

    public RIS(String type) {
        super();
        this.fileFormat = "ris";
        this.fileType = type;
    }

    @Override
    public String makeFormat(){
        String output = "TY - " + this.fileType;

        for (String key : getKeys()) {

            if (!formatFields.get(key).equals("")) {
                output += "\n" + formatFieldsShort.get(key) + " " + formatFields.get(key) + "\n";
            }
        }
        output += "\nER - ";
        return output;
    }
}

/*
TY (fileType) values:
Abbreviation	Type
ABST	Abstract
ADVS	Audiovisual material
AGGR	Aggregated Database
ANCIENT	Ancient Text
ART	Art Work
BILL	Bill
BLOG	Blog
BOOK	Whole book
CASE	Case
CHAP	Book chapter
CHART	Chart
CLSWK	Classical Work
COMP	Computer program
CONF	Conference proceeding
CPAPER	Conference paper
CTLG	Catalog
DATA	Data file
DBASE	Online Database
DICT	Dictionary
EBOOK	Electronic Book
ECHAP	Electronic Book Section
EDBOOK	Edited Book
EJOUR	Electronic Article
WEB	Web Page
ENCYC	Encyclopedia
EQUA	Equation
FIGURE	Figure
GEN	Generic
GOVDOC	Government Document
GRANT	Grant
HEAR	Hearing
ICOMM	Internet Communication
INPR	In Press
JFULL	Journal (full)
JOUR	Journal
LEGAL	Legal Rule or Regulation
MANSCPT	Manuscript
MAP	Map
MGZN	Magazine article
MPCT	Motion picture
MULTI	Online Multimedia
MUSIC	Music score
NEWS	Newspaper
PAMP	Pamphlet
PAT	Patent
PCOMM	Personal communication
RPRT	Report
SER	Serial publication
SLIDE	Slide
SOUND	Sound recording
STAND	Standard
STAT	Statute
THES	Thesis/Dissertation
UNBILL	Unenacted Bill
UNPB	Unpublished work
VIDEO	Video recording
 */